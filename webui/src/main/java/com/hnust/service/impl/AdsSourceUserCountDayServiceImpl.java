package com.hnust.service.impl;

import com.hnust.entity.AdsSourceUserCountDay;
import com.hnust.entity.vo.SourceActivityVO;
import com.hnust.mapper.AdsSourceUserCountDayMapper;
import com.hnust.service.AdsSourceUserCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 各个渠道活跃用户数 service
 */
@Service
public class AdsSourceUserCountDayServiceImpl implements AdsSourceUserCountDayService {

    @Autowired
    private AdsSourceUserCountDayMapper adsSourceUserCountDayMapper;

    @Override
    public ArrayList<AdsSourceUserCountDay> queryAll() {
        return adsSourceUserCountDayMapper.queryAll();
    }

    //根据日期获取各个渠道活跃用户数
    public ArrayList<SourceActivityVO> getByDt(String dt){

        return adsSourceUserCountDayMapper.queryByDt(dt);
    }

}
