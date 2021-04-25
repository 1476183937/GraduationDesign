package com.hnust.entity;

public class AdsUserRetentionDayRate {

    private String statDate;
    private String createDate;
    private Integer retentionDay;
    private Long retentionCount;
    private Long newUidCount;
    private Double retentionRatio;

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(Integer retentionDay) {
        this.retentionDay = retentionDay;
    }

    public Long getRetentionCount() {
        return retentionCount;
    }

    public void setRetentionCount(Long retentionCount) {
        this.retentionCount = retentionCount;
    }

    public Long getNewUidCount() {
        return newUidCount;
    }

    public void setNewUidCount(Long newUidCount) {
        this.newUidCount = newUidCount;
    }

    public Double getRetentionRatio() {
        return retentionRatio;
    }

    public void setRetentionRatio(Double retentionRatio) {
        this.retentionRatio = retentionRatio;
    }
}
