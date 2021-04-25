package com.hnust.service.impl;

import com.hnust.entity.AdsHourseCollectCountDay;
import com.hnust.entity.vo.CollectCountVO;
import com.hnust.mapper.AdsHourseCollectCountDayMapper;
import com.hnust.service.AdsHourseCollectCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsHourseCollectCountDayServiceImpl implements AdsHourseCollectCountDayService {

    @Autowired
    private AdsHourseCollectCountDayMapper adsHourseCollectCountDayMapper;

    @Override
    public ArrayList<AdsHourseCollectCountDay> queryAll() {
        return adsHourseCollectCountDayMapper.queryAll();
    }

    //根据日期获取最近几天的房屋收藏数
    public ArrayList<CollectCountVO> getByDt(String dt, int size){

        return adsHourseCollectCountDayMapper.queryByDt(dt,size);
    }

    //获取日期 dt 那天收藏数前几的房屋
    public ArrayList<AdsHourseCollectCountDay> getCollectCountByDt(String dt,int size){

        return adsHourseCollectCountDayMapper.queryCollectCountByDt(dt,size);
    }

}
