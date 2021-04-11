package com.hnust.entity;

/**
 * @Title:点赞事件:praise
 * @Author: ggh
 * @Date: 2021/4/3 23:10
 */
public class PraiseEvent extends AbstratEvent {

    private String id;	        //主键id
    private String userid;	    //用户id
    private String target_id;	//点赞的对象id
    private String type;	    //点赞类型：评论点赞=1、文字点赞=2
    private String add_time;	//添加时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
