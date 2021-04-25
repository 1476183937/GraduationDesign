package com.hnust.controller;

import com.hnust.entity.AdsUserRetentionDayRate;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsUserRetentionDayRateService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 用户留存率 controller
 */
@Controller
public class UserRetentionController {

    @Autowired
    private AdsUserRetentionDayRateService adsUserRetentionDayRateService;

    /*@RequestMapping("/user_retention.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsUserRetentionDayRate> retentionData = new ArrayList<>();
        Random random = new Random();

        long newUidCount = (1000 + random.nextInt(500));
        long retentionCount = newUidCount-random.nextInt(1000);


        AdsUserRetentionDayRate adsUserRetentionDayRate1 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-15");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-16");

        AdsUserRetentionDayRate adsUserRetentionDayRate2 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-16");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-17");

        AdsUserRetentionDayRate adsUserRetentionDayRate3 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-17");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-18");

        AdsUserRetentionDayRate adsUserRetentionDayRate4 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-18");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-19");

        AdsUserRetentionDayRate adsUserRetentionDayRate5 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-19");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-20");

        AdsUserRetentionDayRate adsUserRetentionDayRate6 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-20");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-21");

        AdsUserRetentionDayRate adsUserRetentionDayRate7 = new AdsUserRetentionDayRate();
        newUidCount = (1000 + random.nextInt(500));
        retentionCount = newUidCount-random.nextInt(1000);
        adsUserRetentionDayRate1.setCreateDate("2020-04-21");
        adsUserRetentionDayRate1.setNewUidCount(newUidCount);
        adsUserRetentionDayRate1.setRetentionCount(retentionCount);
        adsUserRetentionDayRate1.setRetentionDay(1);
        adsUserRetentionDayRate1.setRetentionRatio((double) (Double.parseDouble(retentionCount+"")/newUidCount));
        adsUserRetentionDayRate1.setStatDate("2020-04-22");

        retentionData.add(adsUserRetentionDayRate1);
        retentionData.add(adsUserRetentionDayRate2);
        retentionData.add(adsUserRetentionDayRate3);
        retentionData.add(adsUserRetentionDayRate4);
        retentionData.add(adsUserRetentionDayRate5);
        retentionData.add(adsUserRetentionDayRate6);
        retentionData.add(adsUserRetentionDayRate7);

        ResultEntity<ArrayList<AdsUserRetentionDayRate>> retentionDataEntity = ResultEntity.successWithData(retentionData);
        modelMap.addAttribute("retentionDataEntity",retentionDataEntity);

        return "user_retention";
    }*/

    @RequestMapping("/user_retention.html")
    public String retention(ModelMap modelMap){

        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        //需要获取的结果条数
        int size = 7;
        //留存天数
        int retentionDay = 1;

        //获取数据
        ArrayList<AdsUserRetentionDayRate> retentionData = adsUserRetentionDayRateService.getByDtAndRetentionDay(preDate, size, retentionDay);
        ResultEntity<ArrayList<AdsUserRetentionDayRate>> retentionDataEntity = ResultEntity.successWithData(retentionData);
        modelMap.addAttribute("retentionDataEntity",retentionDataEntity);

        return "user_retention";
    }

    /**
     * 根据日期和留存天数获取最近7天的留存数据
     * @param dt：日期
     * @param rd：留存天数
     * @return
     */
    @RequestMapping("/user_retention")
    @ResponseBody
    public ResultEntity<ArrayList<AdsUserRetentionDayRate>> getByDtAndRetentionDay(@RequestParam("dt") String dt,@RequestParam("rd") int rd){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        int size = 7;
        ArrayList<AdsUserRetentionDayRate> retentionData = adsUserRetentionDayRateService.getByDtAndRetentionDay(preDate, size, rd);

        ResultEntity<ArrayList<AdsUserRetentionDayRate>> retentionDataEntity = ResultEntity.successWithData(retentionData);

        return retentionDataEntity;
    }

}
