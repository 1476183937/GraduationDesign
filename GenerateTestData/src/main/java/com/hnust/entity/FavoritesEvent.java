package com.hnust.entity;

/**
 * @Title:收藏事件:favorites
 * @Author: ggh
 * @Date: 2021/4/3 23:09
 */
public class FavoritesEvent extends AbstratEvent {

    private String id;	        //主键
    private String userId;	    //用户ID
    private String hourseId;	//商品id
    private String hourseName;  //房屋的名称
    private String area;        //房子所在的区域
    private String category;    //类别
    private String addTime;	//创建时间


    public String getHourseName() {
        return hourseName;
    }

    public void setHourseName(String hourseName) {
        this.hourseName = hourseName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
