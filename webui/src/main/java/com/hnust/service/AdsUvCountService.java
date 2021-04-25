package com.hnust.service;

import com.hnust.entity.AdsUvCount;

import java.util.ArrayList;

public interface AdsUvCountService {

    ArrayList<AdsUvCount> queryAll();

    //查询日期 dt 后几天内的数据,如查询最近7天的日活跃数
    ArrayList<AdsUvCount> getByDay(String dt,int size);

    //查询指定日期 dt 后几周内的数据，按周次查询,如查询最近5周的周活跃用户数
    ArrayList<AdsUvCount> getByWk(String dt,int size);

    //查询指定日期 dt 后几月内的数据，按月份查，如查询最近5月的月活跃用户数
    ArrayList<AdsUvCount> getByMn(String dt,int size);

    //获取最近一天的数据，即数据库中 dt 最大的数据
    ArrayList<AdsUvCount> getLatest();

}
