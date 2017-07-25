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
package cn.net.yto.o2iMonitor.quartz.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.net.yto.o2iMonitor.entity.ResultMap;
import cn.net.yto.o2iMonitor.quartz.ScheduleJob;
import cn.net.yto.o2iMonitor.quartz.service.JobConfigService;

/**
 * 任务配置Controller.
 *
 * @author zhangxin
 * @since 2017年7月14日
 */
@RestController
@RequestMapping("/job")
public class JobConfigController {
    public static final Logger LOGGER = Logger.getLogger(JobConfigController.class);
    @Autowired
    private JobConfigService JobConfigService;

    @RequestMapping("/list")
    public ResultMap jobList(Model model) {
        List<ScheduleJob> list = JobConfigService.getAllTask();
        //        model.addAttribute("taskList", list);
        if (CollectionUtils.isEmpty(list)) {
            return ResultMap.create(null, HttpStatus.OK);
        } else {
            return ResultMap.create(JSON.toJSONString(list), HttpStatus.OK);
        }
    }
    
    @RequestMapping("/list")
    public ResultMap add() {
        return null;

    }

}
