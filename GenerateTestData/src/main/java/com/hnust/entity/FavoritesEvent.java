package com.hnust.entity;

/**
 * @Title:收藏事件:favorites
 * @Author: ggh
 * @Date: 2021/4/3 23:09
 */
public class FavoritesEvent extends AbstratEvent {

    private String id;	        //主键
    private String userid;	    //用户ID
    private String hourse_id;	//商品id
    private String hourseName;  //房屋的名称
    private String area;        //房子所在的区域
    private String category;    //类别
    private String add_time;	//创建时间


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

    public String getHourse_id() {
        return hourse_id;
    }

    public void setHourse_id(String hourse_id) {
        this.hourse_id = hourse_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
