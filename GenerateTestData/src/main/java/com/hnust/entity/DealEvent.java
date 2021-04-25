package com.hnust.entity;

/**
 * @Title:成交事件:deal
 * @Author: ggh
 * @Date: 2021/4/3 23:14
 */
public class DealEvent extends AbstratEvent {

    private String id;	        //成交id
    private String agentUserId;	//中介id
    private String userId;	    //客户id
    private String hourseId;	//房子的id
    private String hourseName;	//房子的名称
    private String dealTime;	//成交时间
    private String price;       //成交金额
    private String category;	//房子的类别
    private String area;	    //房子的区域
    private String hourseType;  //户型:一房=1、二房=2、三房=3、四房=4...


    public String getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(String agentUserId) {
        this.agentUserId = agentUserId;
    }

    public String getHourseType() {
        return hourseType;
    }

    public void setHourseType(String hourseType) {
        this.hourseType = hourseType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHourseId() {
        return hourseId;
    }

    public void setHourseId(String hourseId) {
        this.hourseId = hourseId;
    }

    public String getHourseName() {
        return hourseName;
    }

    public void setHourseName(String hourseName) {
        this.hourseName = hourseName;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
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
