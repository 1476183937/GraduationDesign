package com.hnust.entity;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2021/4/4 22:29
 */
public class SearchEvent extends AbstratEvent {

    private String searchWord; //搜索词
    private String userId;     //用户id
    private String time;       //时间

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
