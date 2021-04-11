package com.hnust.entity;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2021/4/4 21:56
 */
public class Hourse {

    private String hourseId;    //房子的唯一id
    private String hourseName;  //房子的名称
    private String category;    //房子的类别
    private String area;        //房子所在的区域
    private String lng;         //经度
    private String lat;         //纬度
    private String price;       //价格
    private String hourseType;  //户型:一房=1、二房=2、三房=3、四房=4...

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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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
