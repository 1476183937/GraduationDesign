package com.hnust.service;

import com.hnust.entity.AdsSourceUserCountDay;
import com.hnust.entity.vo.SourceActivityVO;

import java.util.ArrayList;

public interface AdsSourceUserCountDayService {

    ArrayList<AdsSourceUserCountDay> queryAll();

    //根据日期获取各个渠道活跃用户数
    ArrayList<SourceActivityVO> getByDt(String dt);

}
