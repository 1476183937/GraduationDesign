package com.hnust.service;

import com.hnust.entity.AdsSourceNewCountDay;
import com.hnust.entity.vo.SourceActivityVO;

import java.util.ArrayList;

public interface AdsSourceNewCountDayService {

    ArrayList<AdsSourceNewCountDay> queryAll();

    //根据日期获取各个渠道新增用户数
    ArrayList<SourceActivityVO> getByDt(String dt);

}
