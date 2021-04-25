package com.hnust.service.impl;

import com.hnust.entity.AdsUvCount;
import com.hnust.mapper.AdsUvCountMapper;
import com.hnust.service.AdsUvCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 每日活跃用户数 service
 */
@Service
public class AdsUvCountServiceImpl implements AdsUvCountService {

    @Resource
    private AdsUvCountMapper adsUvCountMapper;

    @Override
    public ArrayList<AdsUvCount> queryAll() {
        return adsUvCountMapper.queryAll();
    }

    //查询日期 dt 后几天内的数据,如查询最近7天的日活跃数
    public ArrayList<AdsUvCount> getByDay(String dt, int size){

        return adsUvCountMapper.queryByDay(dt,size);
    }

    //查询指定日期 dt 后几周内的数据，按周次查询,如查询最近5周的周活跃用户数
    public ArrayList<AdsUvCount> getByWk(String dt, int size){

        return adsUvCountMapper.queryByWk(dt,size);
    }

    //查询指定日期 dt 后几月内的数据，按月份查，如查询最近5月的月活跃用户数
    public ArrayList<AdsUvCount> getByMn(String dt, int size){

        return adsUvCountMapper.queryByMn(dt,size);
    }

    //获取最近一天的数据，即数据库中 dt 最大的数据
    public ArrayList<AdsUvCount> getLatest(){
        return adsUvCountMapper.queryLatest();
    }


}
