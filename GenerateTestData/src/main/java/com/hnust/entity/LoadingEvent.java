package com.hnust.entity;

/**
 * @Title:物品列表页事件:loading
 * @Author: ggh
 * @Date: 2021/4/3 22:46
 */
public class LoadingEvent extends AbstratEvent {

    private int action;          //动作：加载成功=1、失败=2
    private String loadingTime;  //加载时长
    private String loadingWay;   //数据获取方式：读取缓存=1、从接口拉取数据=2
    private String type;         //加载类型：自动加载=1、用户下拽加载=2、底部加载=3

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(String loadingTime) {
        this.loadingTime = loadingTime;
    }

    public String getLoadingWay() {
        return loadingWay;
    }

    public void setLoadingWay(String loadingWay) {
        this.loadingWay = loadingWay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
