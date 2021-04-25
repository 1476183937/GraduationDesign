package com.hnust.service;

import com.hnust.entity.AdsHourseCollectCountDay;
import com.hnust.entity.vo.CollectCountVO;

import java.util.ArrayList;

public interface AdsHourseCollectCountDayService {

    ArrayList<AdsHourseCollectCountDay> queryAll();

    //根据日期获取最近几天的房屋收藏数
    ArrayList<CollectCountVO> getByDt(String dt,int size);

    //获取日期 dt 那天收藏数前几的房屋
    ArrayList<AdsHourseCollectCountDay> getCollectCountByDt(String dt,int size);

}
