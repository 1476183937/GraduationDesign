package com.hnust.entity;

/**
 * @Title:点赞事件:praise
 * @Author: ggh
 * @Date: 2021/4/3 23:10
 */
public class PraiseEvent extends AbstratEvent {

    private String id;	        //主键id
    private String userId;	    //用户id
    private String targetId;	//点赞的对象id
    private String type;	    //点赞类型：评论点赞=1、文字点赞=2
    private String addTime;	//添加时间

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

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
