package com.hnust.entity;

public class LookEvent extends AbstratEvent{

    private String agentUserId;   //带用户看房的用户id，中介
    private String userId;       //看房的用户id
    private String hourseId;     //房屋的id
    private String hourseName;   //房屋的名称
    private String hourseType;   //房屋的户型：1房=1、2房=2...
    private String category;     //房屋的类别
    private String area;         //房屋所在的区域
    private String lookTime;     //看房的时间

    public String getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(String agentUserId) {
        this.agentUserId = agentUserId;
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

    public String getHourseType() {
        return hourseType;
    }

    public void setHourseType(String hourseType) {
        this.hourseType = hourseType;
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

    public String getLookTime() {
        return lookTime;
    }

    public void setLookTime(String lookTime) {
        this.lookTime = lookTime;
    }
}
