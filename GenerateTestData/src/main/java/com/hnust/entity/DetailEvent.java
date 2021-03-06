package com.hnust.entity;

/**
 * @Title:浏览详情页事件:newdetail
 * @Author: ggh
 * @Date: 2021/4/3 22:56
 */
public class DetailEvent extends AbstratEvent {

    private String entry;	        //页面入口来源：应用首页=1、push=2、详情页相关推荐=3
    private String action;	        //动作：开始加载=1，加载成功=2（pv），加载失败=3, 退出页面=4
    private String houseId;	        //商品ID（服务端下发的ID）
    private String hourseName;      //房屋的名称
    private String newsStaytime;	//页面停留时长：从商品开始加载时开始计算，到用户关闭页面所用的时间。若中途用跳转到其它页面了，则暂停计时，待回到详情页时恢复计时。或中途划出的时间超过10分钟，则本次计时作废，不上报本次数据。如未加载成功退出，则报空。
    private String loadingTime;	//加载时长：计算页面开始加载到接口返回数据的时间 （开始加载报0，加载成功或加载失败才上报时间）
    private String category;	    //分类ID（服务端定义的分类ID）
    private String area;            //区域
    private String hourseType;      //户型:一房=1、二房=2、三房=3、四房=4...

    public String getHourseType() {
        return hourseType;
    }

    public void setHourseType(String hourseType) {
        this.hourseType = hourseType;
    }

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

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHourseName() {
        return hourseName;
    }

    public void setHourseName(String hourseName) {
        this.hourseName = hourseName;
    }

    public String getNewsStaytime() {
        return newsStaytime;
    }

    public void setNewsStaytime(String newsStaytime) {
        this.newsStaytime = newsStaytime;
    }

    public String getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(String loadingTime) {
        this.loadingTime = loadingTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
