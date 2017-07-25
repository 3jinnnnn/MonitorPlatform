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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 *
 * @author zhangxin
 * @since 2017年6月26日
 */
@Configuration
public class O2iConfigRedisConfig {
    @Bean(name="o2iConfigJedisPoolConfig")
    @ConfigurationProperties(prefix = "spring.redis.o2iConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }
    
    @Bean(name="o2iConfigJedisPool")
    public JedisPool getJedisPool(@Qualifier("o2iConfigJedisPoolConfig") JedisPoolConfig config,   
            @Value("${spring.redis.o2iConfig.host}")String host,   
            @Value("${spring.redis.o2iConfig.port}")int port, 
            @Value("${spring.redis.o2iConfig.timeOut}")int timeOut) {
        return new JedisPool(config, host, port, timeOut);
    }
}
