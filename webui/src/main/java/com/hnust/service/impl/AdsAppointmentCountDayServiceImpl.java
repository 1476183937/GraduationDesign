package com.hnust.service.impl;

import com.hnust.entity.AdsAppointmentCountDay;
import com.hnust.mapper.AdsAppointmentCountDayMapper;
import com.hnust.service.AdsAppointmentCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日预约数service
 */
@Service
public class AdsAppointmentCountDayServiceImpl implements AdsAppointmentCountDayService {

    @Autowired
    private AdsAppointmentCountDayMapper adsAppointmentCountDayMapper;

    @Override
    public ArrayList<AdsAppointmentCountDay> queryAll() {
        return adsAppointmentCountDayMapper.queryAll();
    }

    @Override
    public ArrayList<AdsAppointmentCountDay> getByDt(String dt, int size) {
        ArrayList<AdsAppointmentCountDay> appointmentCountDay = adsAppointmentCountDayMapper.queryByDt(dt, size);
        return appointmentCountDay;
    }


}
