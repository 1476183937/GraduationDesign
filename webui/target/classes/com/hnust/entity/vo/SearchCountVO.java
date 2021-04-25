package com.hnust.entity.vo;

/**
 * 每天的总的搜索次数
 */
public class SearchCountVO {

    private String dt; //日期
    private Long count;//当天总的搜索次数

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
