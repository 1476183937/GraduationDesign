package com.hnust.service;

import com.hnust.entity.AdsSearchWordCountDay;
import com.hnust.entity.vo.SearchCountVO;

import java.util.ArrayList;

public interface AdsSearchWordCountDayService {

    ArrayList<AdsSearchWordCountDay> queryAll();

    //根据日期获取当天总的搜索次数
    ArrayList<SearchCountVO> getByDt(String dt,int size);

    //根据日期获取当天搜索次数最多的几个词语
    ArrayList<AdsSearchWordCountDay> getTopSearchWord(String dt,int size);

}
