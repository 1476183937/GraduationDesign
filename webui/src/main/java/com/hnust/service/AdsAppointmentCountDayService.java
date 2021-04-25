package com.hnust.service;

import com.hnust.entity.AdsAppointmentCountDay;

import java.util.ArrayList;

public interface AdsAppointmentCountDayService {

    ArrayList<AdsAppointmentCountDay> queryAll();

    //根据日期获取最近几天的成交数
    ArrayList<AdsAppointmentCountDay> getByDt(String dt, int size);

}
