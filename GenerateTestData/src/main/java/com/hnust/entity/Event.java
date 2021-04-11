package com.hnust.entity;

/**
 * @Title: 事件类
 * @Author: ggh
 * @Date: 2021/4/3 22:45
 */
public class Event {

    private String eventTime; //事件产生的时间
    private String eventType; //时间类型
    private AbstratEvent event; //具体的事件

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public AbstratEvent getEvent() {
        return event;
    }

    public void setEvent(AbstratEvent event) {
        this.event = event;
    }
}
