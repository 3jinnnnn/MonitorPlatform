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
package cn.net.yto.o2iMonitor.entity.security;

import java.sql.Timestamp;

/**
 *
 * @author zhangxin
 * @since 2017年6月20日
 */
public class Role {
    private Long id;
    private String name;
    private String status;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private String remark;
    
    public Role(){}
    
    /**
     * @param id
     * @param name
     * @param status
     * @param createTime
     * @param modifyTime
     * @param remark
     */
    public Role(Long id, String name, String status, Timestamp createTime, Timestamp modifyTime,
            String remark) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.remark = remark;
    }
    
    /**
     * @param name
     * @param password
     * @param remark
     */
    public Role(String name, String remark) {
        super();
        this.name = name;
        this.remark = remark;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    /**
     * @return the modifyTime
     */
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", status=" + status + ", createTime=" + createTime
                + ", modifyTime=" + modifyTime + ", remark=" + remark + "]";
    }
    
}
