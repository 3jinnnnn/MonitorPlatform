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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhangxin
 * @since 0.0.1
 */
//@Configuration
public class RedisConfig {
    //http://www.jianshu.com/p/1c1625278eec
    private static final int TIME_OUT = 5000;
    @Autowired
    private Environment env;
    
    @Bean(name="monitorJedis")
    public Jedis getMonitorJedis(){
        String host = env.getProperty("monitor.redis.host");
        int port = Integer.parseInt(env.getProperty("monitor.redis.port"));
        Jedis jedis = new Jedis(host, port, TIME_OUT);
        return jedis;
    }
    @Bean(name="configJedis")
    public Jedis getConfigJedis(){
        String host = env.getProperty("config.redis.host");
        int port = Integer.parseInt(env.getProperty("config.redis.port"));
        Jedis jedis = new Jedis(host, port, TIME_OUT);
        return jedis;
    }
}
