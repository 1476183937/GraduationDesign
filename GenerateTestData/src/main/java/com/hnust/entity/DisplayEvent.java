package com.hnust.entity;

/**
 * @Title:列表页的物品点击事件：display
 * @Author: ggh
 * @Date: 2021/4/3 22:50
 */
public class DisplayEvent extends AbstratEvent{

    private int action;        //动作：加载成功=1，加载失败=2
    private String hourseId;   //房屋的ID
    private String hourseName; //房屋的名称
    private String place;      //顺序（第几条商品，第一条为0，第二条为1，如此类推）
    private String category;   //物品分类ID（服务端定义的分类ID）
    private String area;       //房屋所在区域
    private String hourseType; //户型:一房=1、二房=2、三房=3、四房=4...

    public String getHourseType() {
        return hourseType;
    }

    public void setHourseType(String hourseType) {
        this.hourseType = hourseType;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
