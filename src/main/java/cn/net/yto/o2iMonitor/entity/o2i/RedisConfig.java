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
package cn.net.yto.o2iMonitor.entity.o2i;

import java.util.Date;

/**
 * 应用配置类.
 * @author zhangxin
 * @since 0.0.1
 */
public class RedisConfig {
    /** 键  .*/
    private String key;
    /** 应用类型  .*/
    private String jobType;
    /** 应用开关  .*/
    private String jobSwitch;
    /** 数据段 .*/
    private String dataRange;
    /** 数据源  .*/
    private String dataSource;
    /** 线程id  .*/
    private String threadId;
    /** 线程开始时间  .*/
    private Date startTime;
    /** 线程最后刷新时间  .*/
    private Date refreshTime;
    /** 线程类型(NEW OR UPDATE/DELETE)  .*/
    private String threadType;
    /** (失败线程)拿数据的开始位置(0-999). */
    private int startNum;
    /** (失败线程)拿数据的结束位置(1-1000). */
    private int endNum;

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(final String jobType) {
        this.jobType = jobType;
    }

    public String getJobSwitch() {
        return jobSwitch;
    }

    public void setJobSwitch(final String jobSwitch) {
        this.jobSwitch = jobSwitch;
    }

    public String getDataRange() {
        return dataRange;
    }

    public void setDataRange(final String dataRange) {
        this.dataRange = dataRange;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(final String dataSource) {
        this.dataSource = dataSource;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(final String threadId) {
        this.threadId = threadId;
    }

    /**
     * 
     * @return startTime
     */
    public Date getStartTime() {
        //return (Date) startTime.clone();
        if(startTime == null){
            return null;
        }
        return (Date) startTime.clone();
    }

    /**
     * 
     * @param startTime 开始时间
     */
    public void setStartTime(final Date startTime) {
        if(startTime==null){
            this.startTime = null;
        }else{
            this.startTime = (Date) startTime.clone();
        }
    }
    /**
     * 
     * @return refreshTime
     */
    public Date getRefreshTime() {
        //        return (Date) refreshTime.clone();
        if(refreshTime==null){
            return null;
        }
        return (Date) refreshTime.clone();
    }

    /**
     * 
     * @param refreshTime 更新时间
     */
    public void setRefreshTime(final Date refreshTime) {
        if(refreshTime==null){
            this.refreshTime = null;
        }else{
            this.refreshTime = (Date) refreshTime.clone();
        }
    }

    public String getThreadType() {
        return threadType;
    }

    public void setThreadType(final String threadType) {
        this.threadType = threadType;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(final int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(final int endNum) {
        this.endNum = endNum;
    }
}
