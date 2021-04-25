package com.hnust.controller;


import com.hnust.entity.ResultEntity;
import com.hnust.entity.vo.SourceActivityVO;
import com.hnust.service.AdsSourceNewCountDayService;
import com.hnust.service.AdsSourceUserCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 各个渠道活跃用户和新增用户
 */
@Controller
public class SourceCountController {

    @Autowired
    private AdsSourceUserCountDayService adsSourceUserCountDayService;
    @Autowired
    private AdsSourceNewCountDayService adsSourceNewCountDayService;

    @RequestMapping("/source_count.html")
    public String sourceCount(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");

        ArrayList<SourceActivityVO> sourceUserCount = adsSourceUserCountDayService.getByDt(now);
        ArrayList<SourceActivityVO> sourceNewCount = adsSourceNewCountDayService.getByDt(now);

        ResultEntity<ArrayList<SourceActivityVO>> sourceUserCountEntity = ResultEntity.successWithData(sourceUserCount);
        ResultEntity<ArrayList<SourceActivityVO>> sourceNewCountEntity = ResultEntity.successWithData(sourceNewCount);

        modelMap.addAttribute("sourceUserCountEntity",sourceUserCountEntity);
        modelMap.addAttribute("sourceNewCountEntity",sourceNewCountEntity);

        return "source_count";
    }


    /**
     * 根据日期获取各个渠道新增用户数
     * @param dt
     * @return
     */
    @RequestMapping("/source_new")
    @ResponseBody
    public ResultEntity<ArrayList<SourceActivityVO>> getSourceNewCountDay(@RequestBody String dt){


        ArrayList<SourceActivityVO> sourceNewCount = adsSourceNewCountDayService.getByDt(dt);

        ResultEntity<ArrayList<SourceActivityVO>> sourceNewCountEntity = ResultEntity.successWithData(sourceNewCount);

        return sourceNewCountEntity;
    }


    /**
     * 根据日期获取各个渠道活跃数
     * @param dt
     * @return
     */
    @RequestMapping("/source_activity")
    @ResponseBody
    public ResultEntity<ArrayList<SourceActivityVO>> getSourceActivityDay(@RequestBody String dt){

        ArrayList<SourceActivityVO> sourceUserCount = adsSourceUserCountDayService.getByDt(dt);

        ResultEntity<ArrayList<SourceActivityVO>> sourceUserCountEntity = ResultEntity.successWithData(sourceUserCount);

        return sourceUserCountEntity;
    }

}
