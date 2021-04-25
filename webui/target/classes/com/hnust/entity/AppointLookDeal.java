package com.hnust.entity;

import java.util.ArrayList;

/**
 * 包含预约、带看、成交的实体类
 */
public class AppointLookDeal {

    private ArrayList<AdsAppointmentCountDay> appointmentCountDayList;
    private ArrayList<AdsDealCountDay> dealCountDayList;
    private ArrayList<AdsLookCountDay> lookCountDayList;

    public ArrayList<AdsAppointmentCountDay> getAppointmentCountDayList() {
        return appointmentCountDayList;
    }

    public void setAppointmentCountDayList(ArrayList<AdsAppointmentCountDay> appointmentCountDayList) {
        this.appointmentCountDayList = appointmentCountDayList;
    }

    public ArrayList<AdsDealCountDay> getDealCountDayList() {
        return dealCountDayList;
    }

    public void setDealCountDayList(ArrayList<AdsDealCountDay> dealCountDayList) {
        this.dealCountDayList = dealCountDayList;
    }

    public ArrayList<AdsLookCountDay> getLookCountDayList() {
        return lookCountDayList;
    }

    public void setLookCountDayList(ArrayList<AdsLookCountDay> lookCountDayList) {
        this.lookCountDayList = lookCountDayList;
    }
}
