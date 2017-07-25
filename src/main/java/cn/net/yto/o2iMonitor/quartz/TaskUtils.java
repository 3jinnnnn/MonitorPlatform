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
package cn.net.yto.o2iMonitor.quartz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


/**
 * 任务调度工具.
 *
 * @author zhangxin
 * @since 2017年6月23日
 */
public final class TaskUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(TaskUtils.class);
    private TaskUtils(){}
    
    /**
     * 通过反射调用scheduleJob中定义的方法
     * 
     * @param scheduleJob
     */
    public static void invokMethod(ScheduleJob scheduleJob) {
        Object object = null;
        Class<?> clazz = null;
        if (!StringUtils.isEmpty(scheduleJob.getSpringId())) {
            object = SpringUtils.getBean(scheduleJob.getSpringId());
        } else if (!StringUtils.isEmpty(scheduleJob.getBeanClass())) {
            try {
                clazz = Class.forName(scheduleJob.getBeanClass());
                object = clazz.newInstance();
            } catch (final Exception e) {
                LOGGER.error(e.getMessage(), e);
            }

        }
        if (object == null) {
            LOGGER.error("任务名称 = [{}]未启动成功，请检查是否配置正确！！！", scheduleJob.getName());
            return;
        }
        clazz = object.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
        } catch (NoSuchMethodException e) {
            LOGGER.error("任务名称 = [{}]未启动成功，方法名设置错误！！！", scheduleJob.getName());
        } catch (final SecurityException e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (method != null) {
            try {
                method.invoke(object);
            } catch (final IllegalAccessException e) {
                LOGGER.error(e.getMessage(), e);
            } catch (final IllegalArgumentException e) {
                LOGGER.error(e.getMessage(), e);
            } catch (final InvocationTargetException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        LOGGER.info("任务名称 = [{}]启动成功", scheduleJob.getName());
    }
    
}
