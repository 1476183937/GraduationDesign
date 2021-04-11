package com.hnust.entity;

/**
 * @Title:日志数据
 * @Author: ggh
 * @Date: 2021/4/3 22:34
 */
public class LogData {

    private CommonLogData cm; //所有日志数据都有的部分
//    private AbstratEvent event;
    private Event event;

    public CommonLogData getCm() {
        return cm;
    }

    public void setCm(CommonLogData cm) {
        this.cm = cm;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
