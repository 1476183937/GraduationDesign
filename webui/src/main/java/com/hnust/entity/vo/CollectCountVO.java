package com.hnust.entity.vo;

/**
 * 每日收藏统计实体类
 */
public class CollectCountVO {

    private String dt;
    private Long collectCount;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Long getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Long collectCount) {
        this.collectCount = collectCount;
    }
}
