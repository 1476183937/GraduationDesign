package com.hnust.entity;

/**
 * @Title:预约事件:appointment
 * @Author: ggh
 * @Date: 2021/4/3 23:12
 */
public class AppointmentEvent extends AbstratEvent {

    private String id;	              //主键id
    private String userId;	          //用户id
    private String hourseId;	      //房子的id
    private String hourseName;	      //房子的名称
    private String appointmentTime;  //客户预约看房的时间
    private String category;	      //房子的类别
    private String area;	          //区域

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

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
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
