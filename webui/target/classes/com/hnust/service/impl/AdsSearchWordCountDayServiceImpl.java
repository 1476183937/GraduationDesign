package com.hnust.service.impl;

import com.hnust.entity.AdsSearchWordCountDay;
import com.hnust.entity.vo.SearchCountVO;
import com.hnust.mapper.AdsSearchWordCountDayMapper;
import com.hnust.service.AdsSearchWordCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 搜索统计 service
 */
@Service
public class AdsSearchWordCountDayServiceImpl implements AdsSearchWordCountDayService {

    @Autowired
    private AdsSearchWordCountDayMapper adsSearchWordCountDayMapper;

    @Override
    public ArrayList<AdsSearchWordCountDay> queryAll() {
        return adsSearchWordCountDayMapper.queryAll();
    }

    //根据日期获取当天总的搜索次数
    public ArrayList<SearchCountVO> getByDt(String dt, int size){

        return adsSearchWordCountDayMapper.queryByDt(dt,size);
    }

    //根据日期获取当天搜索次数最多的几个词语
    public ArrayList<AdsSearchWordCountDay> getTopSearchWord(String dt,int size){

        return adsSearchWordCountDayMapper.getTopSearchWord(dt,size);
    }

}
