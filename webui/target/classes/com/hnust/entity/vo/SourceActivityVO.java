package com.hnust.entity.vo;

/**
 * 各个渠道活跃和新增用户数返回结果类
 */
public class SourceActivityVO {

    private String sourceName; //渠道名称
    private String count;      //活跃数或者新增数

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
