package com.hnust.entity;

public class AdsUserRetentionCountDay {

    private String statDate;
    private String createDate;
    private Integer retentionDay;
    private Long retentionCount;

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
}
