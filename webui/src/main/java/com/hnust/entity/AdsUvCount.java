package com.hnust.entity;

public class AdsUvCount {

    private String dt;
    private Long dayCount;
    private Long wkCount;
    private Long mnCount;
    private String isWeekend;
    private String isMonthend;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Long getDayCount() {
        return dayCount;
    }

    public void setDayCount(Long dayCount) {
        this.dayCount = dayCount;
    }

    public Long getWkCount() {
        return wkCount;
    }

    public void setWkCount(Long wkCount) {
        this.wkCount = wkCount;
    }

    public Long getMnCount() {
        return mnCount;
    }

    public void setMnCount(Long mnCount) {
        this.mnCount = mnCount;
    }

    public String getIsWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(String isWeekend) {
        this.isWeekend = isWeekend;
    }

    public String getIsMonthend() {
        return isMonthend;
    }

    public void setIsMonthend(String isMonthend) {
        this.isMonthend = isMonthend;
    }


}
