package com.hnust.entity;

/**
 * @Title:所有日志数据都有的公共部分
 * @Author: ggh
 * @Date: 2021/4/3 22:35
 */
public class CommonLogData {

    private String mid;  //设备标识
    private String uid;  //用户id
    private String sr;   //渠道
    private String os;   //系统版本号
    private String ar;   //区域
    private String md;   //手机型号
    private String ba;   //手机品牌
    private String hw;   //屏幕宽高：123x345
    private String t;    //客户单产生日志的时间，时间戳类型
    private String ln;   //经度
    private String la;   //纬度
    private String url;  //请求的url

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getHw() {
        return hw;
    }

    public void setHw(String hw) {
        this.hw = hw;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
