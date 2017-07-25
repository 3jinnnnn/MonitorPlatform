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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.net.yto.o2iMonitor.config.LocalConstants.O2iOpkind;
import cn.net.yto.o2iMonitor.entity.security.Msg;
import cn.net.yto.o2iMonitor.service.O2iMonitorService;

/**
 *
 * @author zhangxin
 * @since 2017年6月20日
 */
@Controller
public class HomeController {
    @Autowired
    private O2iMonitorService o2iMonitorService;
    
    @RequestMapping({"/", "index"})
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        model.addAttribute(O2iOpkind.OFFLINE189, o2iMonitorService.getConfigCount(O2iOpkind.OFFLINE189));
        model.addAttribute(O2iOpkind.OFFLINE190, o2iMonitorService.getConfigCount(O2iOpkind.OFFLINE190));
        model.addAttribute(O2iOpkind.C5190, o2iMonitorService.getConfigCount(O2iOpkind.C5190));
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login_1";
    }
}
