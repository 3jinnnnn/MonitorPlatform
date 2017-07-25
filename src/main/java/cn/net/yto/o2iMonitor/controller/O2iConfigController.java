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
package cn.net.yto.o2iMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.net.yto.o2iMonitor.entity.ResultMap;
import cn.net.yto.o2iMonitor.service.O2iMonitorService;

/**
 * o2i配置.
 * 
 * @author zhangxin
 * @since 2017年6月23日
 */
@RestController
public class O2iConfigController {
    @Autowired
    private O2iMonitorService o2iMonitorService;
    
    @RequestMapping(value="/config-switch", method= RequestMethod.POST)
    public ResultMap configWitch(@RequestParam(name="name", required=true) final String name, 
            @RequestParam(name="value", required=true) final String value){
        return o2iMonitorService.flushOrRecoverConfig(name, value);
    }
    
    @RequestMapping(value="/config-modify", method= RequestMethod.POST)
    public ResultMap configModify(@RequestParam(name="name", required=true) final String name, 
            @RequestParam(name="value", required=true) final int value){
        return o2iMonitorService.configModify(name, value);
    }
    
    
    
}
