package com.hnust.service.impl;

import com.hnust.entity.AdsHourseDetailViewCountDay;
import com.hnust.mapper.AdsHourseDetailViewCountDayMapper;
import com.hnust.service.AdsHourseDetailViewCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 详情页浏览次数 serivce
 */
@Service
public class AdsHourseDetailViewCountDayServiceImpl implements AdsHourseDetailViewCountDayService {

    @Autowired
    private AdsHourseDetailViewCountDayMapper adsHourseDetailViewCountDayMapper;

    @Override
    public ArrayList<AdsHourseDetailViewCountDay> queryAll() {
        return adsHourseDetailViewCountDayMapper.queryAll();
    }

    //根据日期 dt 获取近几天详情页浏览次数
    public ArrayList<AdsHourseDetailViewCountDay> getByDt(String dt,int size){

        return adsHourseDetailViewCountDayMapper.queryByDt(dt,size);
    }

}
