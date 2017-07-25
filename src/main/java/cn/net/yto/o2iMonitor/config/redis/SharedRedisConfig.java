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
package cn.net.yto.o2iMonitor.config.redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 
 *
 * @author zhangxin
 * @since 2017年6月26日
 */
//@Configuration
public class SharedRedisConfig {
    @Autowired
    private Environment env;
    
    @ConfigurationProperties(prefix = "spring.redis.shard.monitor")
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }
    
    @Bean(name="monitorJedisPool")
    public ShardedJedisPool getJedisPool() {
        try {
            List<JedisShardInfo> shardList = new ArrayList<>();
            String hostStr = env.getProperty("spring.redis.shard.monitor.hostList");
            int timeOut = Integer.parseInt(env.getProperty("spring.redis.shard.monitor.timeOut"));
            if(!StringUtils.isEmpty(hostStr)){
                String[] hosts = hostStr.split(",");
                for(int i = 0; i < hosts.length; i++){
                    String[] temp = hosts[i].split(":");
                    JedisShardInfo info = new JedisShardInfo(temp[0], Integer.valueOf(temp[1]), timeOut);
                    shardList.add(info);
                }
            }
            
            if(shardList.size() == 0){
                //无法加载redis
                throw new IOException();
            }
            return new ShardedJedisPool(getJedisPoolConfig(), shardList);
        } catch (Exception e) {
            throw new RuntimeException("无法加载资源文件!");
        }
    }
}
