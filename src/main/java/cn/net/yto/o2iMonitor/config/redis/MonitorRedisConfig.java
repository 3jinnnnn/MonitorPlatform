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
import org.springframework.context.annotation.Primary;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 *
 * @author zhangxin
 * @since 2017年6月26日
 */
@Configuration
public class MonitorRedisConfig {
    @Primary
    @Bean(name="monitorJedisPoolConfig")
    @ConfigurationProperties(prefix = "spring.redis.monitor")
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }
    @Primary
    @Bean(name="monitorJedisPool")
    public JedisPool getJedisPool(@Qualifier("monitorJedisPoolConfig") JedisPoolConfig config,   
            @Value("${spring.redis.monitor.host}")String host,   
            @Value("${spring.redis.monitor.port}")int port, 
            @Value("${spring.redis.monitor.timeOut}")int timeOut) {
        return new JedisPool(config, host, port, timeOut);
    }
}
