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
package cn.net.yto.o2iMonitor.config.datasource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 配置Druid监控Servlet.
 *
 * @author zhangxin
 * @since 2017年6月29日
 */
@Configuration
public class DruidConfiguration {
    /**
     * 注册ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean() {
      ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
      /** 初始化参数配置，initParams**/
      //白名单
      bean.addInitParameter("allow", "127.0.0.1");
      //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
      bean.addInitParameter("deny", "192.168.1.73");
      //登录查看信息的账号密码.
      bean.addInitParameter("loginUsername", "admin");
      bean.addInitParameter("loginPassword", "admin");
      //是否能够重置数据.
      bean.addInitParameter("resetEnable", "false");
      return bean;
    }
    /**
     * 注册FilterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
      FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
      //添加过滤规则.
      bean.addUrlPatterns("/*");
      //添加不需要忽略的格式信息.
      bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
      return bean;
    }
}
