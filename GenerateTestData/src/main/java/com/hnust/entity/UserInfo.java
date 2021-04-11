package com.hnust.entity;

import java.util.ArrayList;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2021/4/4 13:03
 */
public class UserInfo {

    private String uid;
    private String userName;
    private String phoneNum;
    private int age;
    private String lng; //经度
    private String lat; //纬度
    private String area; //区域
    private ArrayList<String> mds; //用户常用的手机型号
    private ArrayList<String> heightXwidth; //用户常用的手机的屏幕宽高
    private ArrayList<String> os; //用户常用的手机的系统版本号
    private ArrayList<String> network; //用户常用的网络类型
    private ArrayList<String> bas; //用户常用的手机品牌

    public ArrayList<String> getBas() {
        return bas;
    }

    public void setBas(ArrayList<String> bas) {
        this.bas = bas;
    }

    public ArrayList<String> getMds() {
        return mds;
    }

    public void setMds(ArrayList<String> mds) {
        this.mds = mds;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<String> getNetwork() {
        return network;
    }

    public void setNetwork(ArrayList<String> network) {
        this.network = network;
    }

    public ArrayList<String> getOs() {
        return os;
    }

    public void setOs(ArrayList<String> os) {
        this.os = os;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public ArrayList<String> getHeightXwidth() {
        return heightXwidth;
    }

    public void setHeightXwidth(ArrayList<String> heightXwidth) {
        this.heightXwidth = heightXwidth;
    }
}
