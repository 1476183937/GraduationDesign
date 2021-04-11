package com.hnust.entity;

/**
 * @Title:评论事件:comment
 * @Author: ggh
 * @Date: 2021/4/3 23:01
 */
public class CommentEvent extends AbstratEvent {

    private String commentId;	   //评论id
    private String commentedId;    //被评论的房屋或者文章的id
    private String userid;	       //用户id
    private String p_commentId;   //父级评论id(为0则是一级评论,不为0则是回复)
    private String content;	       //评论内容
    private String addtime;	       //创建时间
    //private String praiseCount;    //点赞数量
    //private String replyCount;	   //回复数量


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(String commentedId) {
        this.commentedId = commentedId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getP_commentId() {
        return p_commentId;
    }

    public void setP_commentId(String p_commentId) {
        this.p_commentId = p_commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
