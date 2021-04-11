package com.hnust.entity;

/**
 * @Title:广告事件:ad
 * @Author: ggh
 * @Date: 2021/4/3 22:59
 */
public class AdEvent extends AbstratEvent {

    private String entry;	     //入口：商品列表页=1 应用首页=2 商品详情页=3
    private String action;	     //动作：请求广告=1 取缓存广告=2  广告位展示=3 广告展示=4 广告点击=5
    private String content;	     //状态：成功=1  失败=2
    private String detail;	     //失败码（没有则上报空）
    private String source;	     //广告来源:百度=1、微博=2
    private String behavior;	 //用户行为：主动获取广告=1;  被动获取广告=2

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
