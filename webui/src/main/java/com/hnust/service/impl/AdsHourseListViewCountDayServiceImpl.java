package com.hnust.service.impl;

import com.hnust.entity.AdsHourseListViewCountDay;
import com.hnust.mapper.AdsHourseListViewCountDayMapper;
import com.hnust.service.AdsHourseListViewCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 列表页浏览次数
 */
@Service
public class AdsHourseListViewCountDayServiceImpl implements AdsHourseListViewCountDayService {

    @Autowired
    private AdsHourseListViewCountDayMapper adsHourseListViewCountDayMapper;

    @Override
    public ArrayList<AdsHourseListViewCountDay> queryAll() {
        return adsHourseListViewCountDayMapper.queryAll();
    }

    //根据日期 dt 获取列表页浏览次数
    public ArrayList<AdsHourseListViewCountDay> getByDt(String dt,int size){

        return adsHourseListViewCountDayMapper.queryByDt(dt,size);
    }

}
