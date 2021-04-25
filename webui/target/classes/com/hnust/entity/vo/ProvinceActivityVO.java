package com.hnust.entity.vo;

/**
 * 各个省份活跃用户数实体类
 */
public class ProvinceActivityVO {

    private String provinceName;
    private Long activityCount;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(Long activityCount) {
        this.activityCount = activityCount;
    }
}
