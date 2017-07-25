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

/**
 * 录单展开配置的配置
 * @author zhangxin
 * @since 0.0.1
 */
public class O2iConfig {
    private String jobType;
    private String dataSource;
    private String threadType;
    private int threadNum;
    
    /**
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }
    /**
     * @param jobType the jobType to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    /**
     * @return the dataSource
     */
    public String getDataSource() {
        return dataSource;
    }
    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    /**
     * @return the threadType
     */
    public String getThreadType() {
        return threadType;
    }
    /**
     * @param threadType the threadType to set
     */
    public void setThreadType(String threadType) {
        this.threadType = threadType;
    }
    /**
     * @return the threadNum
     */
    public int getThreadNum() {
        return threadNum;
    }
    /**
     * @param threadNum the threadNum to set
     */
    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }
    
    
}
