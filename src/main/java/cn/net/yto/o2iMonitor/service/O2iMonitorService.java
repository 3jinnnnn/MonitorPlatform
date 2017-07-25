/*
 * Copyright © 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.net.yto.o2iMonitor.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import cn.net.yto.o2iMonitor.entity.ResultMap;
import cn.net.yto.o2iMonitor.entity.o2i.ConfigStatus;
import cn.net.yto.o2iMonitor.entity.o2i.O2iConfig;
import cn.net.yto.o2iMonitor.entity.o2i.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class O2iMonitorService {
    private static final String REDIS_CONFIG = "redis_config";
    
    @Autowired
    @Qualifier("monitorJedisPool")
    private JedisPool monitorJedisPool;
    
    @Autowired
    @Qualifier("o2iConfigJedisPool")
    private JedisPool o2iJedisPool;
    
    
    /**
     * 
     * @param opKind 配置开头
     * @return 配置状态实体
     */
    public ConfigStatus getConfigCount(final String opKind){
        ConfigStatus configStatus = new ConfigStatus();
        Jedis monitorJedis = monitorJedisPool.getResource();
        Jedis configJedis = o2iJedisPool.getResource();
        
        String configStr = monitorJedis.hget(REDIS_CONFIG, opKind);
        int configNum = JSON.parseObject(configStr, O2iConfig.class).getThreadNum();
        int curentNum = configJedis.keys(opKind+"*").size();
        
        monitorJedis.close();
        configJedis.close();
        
        configStatus.setName(opKind);
        configStatus.setConfigNum(configNum);
        configStatus.setCurentNum(curentNum);
        generateColor(configStatus);
        return configStatus;
    }
    
    private void generateColor(final ConfigStatus configStatus){
        if(configStatus.getCurentNum() == 0){
            configStatus.setColor("red");
        }else if(configStatus.getCurentNum()==configStatus.getConfigNum()){
            configStatus.setColor("blue");
        }else{
            configStatus.setColor("yellow");
        }
    }
    
    /**
     * 清空or重刷配置.
     * @param name 应用opkind
     * @param value on or off
     * @return
     */
    public ResultMap flushOrRecoverConfig(final String name, final String value){
        ResultMap resultMap = null;
        try{
            switch (value) {
                case "on":
                    flushConfig(name);
                    recoverConfig(name);
                    resultMap = ResultMap.create("成功", HttpStatus.OK);
                    break;
                case "off":
                    flushConfig(name);
                    resultMap = ResultMap.create("成功", HttpStatus.OK);
                    break;
                default:
                    resultMap = ResultMap.create("参数异常,操作失败", HttpStatus.BAD_REQUEST);
                    break;
            }
        }catch(final Exception e){
            resultMap = ResultMap.create(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultMap;
    }
    
    /**
     * 清空配置.
     * @param name 应用opkind
     * @throws Exception Exception
     */
    public void flushConfig(final String name) throws Exception{
        Jedis configJedis = o2iJedisPool.getResource();
        Set<String> configSet = configJedis.keys(name+"*");
        if(!CollectionUtils.isEmpty(configSet)){
            configJedis.del(configSet.toArray(new String[0]));
        }
        configJedis.close();
    }
    
    /**
     * 重刷配置.
     * @param name 应用opkind
     * @throws Exception Exception
     */
    public void recoverConfig(final String name) throws Exception{
        Jedis monitorJedis = monitorJedisPool.getResource();
        Jedis configJedis = o2iJedisPool.getResource();
        
        String configStr = monitorJedis.hget(REDIS_CONFIG, name);
        O2iConfig o2iConfig = JSON.parseObject(configStr, O2iConfig.class);
        for(int i = 0; i< o2iConfig.getThreadNum(); i++){
            RedisConfig rc = new RedisConfig();
            rc.setDataRange(String.valueOf(i));
            rc.setDataSource(o2iConfig.getDataSource());
            rc.setJobSwitch("on");
            rc.setJobType(o2iConfig.getJobType());
            rc.setThreadType(o2iConfig.getThreadType());
            configJedis.set(o2iConfig.getJobType()+"-"+o2iConfig.getThreadType()+"-"+o2iConfig.getDataSource()+"-"+i, JSON.toJSONString(rc));
        }
        
        monitorJedis.close();
        configJedis.close();
    }
    
    /**
     * 调整默认的配置数量.
     * @param name 应用opkind
     * @param num 数量
     * @return ResultMap
     */
    public ResultMap configModify(final String name, final int num){
        ResultMap resultMap = null;
        Jedis monitorJedis = monitorJedisPool.getResource();
        try {
            String value = monitorJedis.hget(REDIS_CONFIG, name);
            O2iConfig o2iConfig = JSON.parseObject(value, O2iConfig.class);
            o2iConfig.setThreadNum(num);
            monitorJedis.hset(REDIS_CONFIG, name, JSON.toJSONString(o2iConfig));
            resultMap = ResultMap.create("修改配置成功", HttpStatus.OK);
        } catch (final Exception e) {
            resultMap = ResultMap.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), "修改配置失败", e.getMessage());
        }
        monitorJedis.close();
        return resultMap;
    }
    
}
