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
    private String filterArea; //过滤条件中的区域
    private String filterHourseType; //过滤条件中的户型
    private String filterPrice; //过滤条件中的价格
    private String filterCategory; //过滤条件中的类别


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

    public String getFilterArea() {
        return filterArea;
    }

    public void setFilterArea(String filterArea) {
        this.filterArea = filterArea;
    }

    public String getFilterHourseType() {
        return filterHourseType;
    }

    public void setFilterHourseType(String filterHourseType) {
        this.filterHourseType = filterHourseType;
    }

    public String getFilterPrice() {
        return filterPrice;
    }

    public void setFilterPrice(String filterPrice) {
        this.filterPrice = filterPrice;
    }

    public String getFilterCategory() {
        return filterCategory;
    }

    public void setFilterCategory(String filterCategory) {
        this.filterCategory = filterCategory;
    }
}
