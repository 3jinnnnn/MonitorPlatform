package cn.net.yto.o2iMonitor.quartz;

import java.sql.Timestamp;

/**
 * 计划任务实体类.
 * 
 * @author zhangxin
 * @since 2017年6月23日
 */
public class ScheduleJob {

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";
    private Long id;
    private String name; //任务名称
    private String group; //任务分组
    private String status; //任务状态 是否启动任务
    private String cron; //cron表达式
    private String description; //描述
    private String beanClass; //任务执行时调用哪个类的方法 包名+类名
    private String isConcurrent; //任务是否有状态
    private String springId; //spring bean
    private String methodName; //任务调用的方法名
    private Timestamp createTime;
    private Timestamp updateTime;

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
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
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
     * @return the cron
     */
    public String getCron() {
        return cron;
    }

    /**
     * @param cron the cron to set
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the beanClass
     */
    public String getBeanClass() {
        return beanClass;
    }

    /**
     * @param beanClass the beanClass to set
     */
    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * @return the isConcurrent
     */
    public String getIsConcurrent() {
        return isConcurrent;
    }

    /**
     * @param isConcurrent the isConcurrent to set
     */
    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * @return the springId
     */
    public String getSpringId() {
        return springId;
    }

    /**
     * @param springId the springId to set
     */
    public void setSpringId(String springId) {
        this.springId = springId;
    }

    /**
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName the methodName to set
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
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
     * @return the updateTime
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}