package com.hnust.controller;


import com.hnust.entity.AdsSlientCount;
import com.hnust.entity.AdsWastageCount;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsSlientCountService;
import com.hnust.service.AdsWastageCountService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 流失用户数 controller
 */
@Controller
public class WastageCountController {

    @Autowired
    private AdsWastageCountService adsWastageCountService;

    @Autowired
    private AdsSlientCountService adsSlientCountService;

    @RequestMapping("/wastage_count.html")
    public String wastage(ModelMap modelMap){

        //获取当前的日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        int size = 7;

        //获取流失用户数的数据
        ArrayList<AdsWastageCount> wastageCounts = adsWastageCountService.getByDt(preDate, size);
        ResultEntity<ArrayList<AdsWastageCount>> wastageCountsEntity = ResultEntity.successWithData(wastageCounts);

        //获取沉默用户数的数据
        ArrayList<AdsSlientCount> slientCounts = adsSlientCountService.getByDt(preDate, size);
        ResultEntity<ArrayList<AdsSlientCount>> slientCountsEntity = ResultEntity.successWithData(slientCounts);


        modelMap.addAttribute("wastageCountsEntity",wastageCountsEntity);
        modelMap.addAttribute("slientCountsEntity",slientCountsEntity);

        return "wastage_count";
    }

    /*@RequestMapping("/wastage_count.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsWastageCount> wastageCounts = new ArrayList<>();

        Random random = new Random();
        AdsWastageCount adsWastageCount1 = new AdsWastageCount();
        adsWastageCount1.setDt("2021-04-16");
        adsWastageCount1.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount2 = new AdsWastageCount();
        adsWastageCount2.setDt("2021-04-17");
        adsWastageCount2.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount3 = new AdsWastageCount();
        adsWastageCount3.setDt("2021-04-18");
        adsWastageCount3.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount4 = new AdsWastageCount();
        adsWastageCount4.setDt("2021-04-19");
        adsWastageCount4.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount5 = new AdsWastageCount();
        adsWastageCount5.setDt("2021-04-20");
        adsWastageCount5.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount6 = new AdsWastageCount();
        adsWastageCount6.setDt("2021-04-21");
        adsWastageCount6.setWastageCount((long) (1100+random.nextInt(500)));

        AdsWastageCount adsWastageCount7 = new AdsWastageCount();
        adsWastageCount7.setDt("2021-04-22");
        adsWastageCount7.setWastageCount((long) (1100+random.nextInt(500)));

        wastageCounts.add(adsWastageCount1);
        wastageCounts.add(adsWastageCount2);
        wastageCounts.add(adsWastageCount3);
        wastageCounts.add(adsWastageCount4);
        wastageCounts.add(adsWastageCount5);
        wastageCounts.add(adsWastageCount6);
        wastageCounts.add(adsWastageCount7);

        ResultEntity<ArrayList<AdsWastageCount>> wastageCountsEntity = ResultEntity.successWithData(wastageCounts);

        modelMap.addAttribute("wastageCountsEntity",wastageCountsEntity);

        ArrayList<AdsSlientCount> slientCounts = new ArrayList<>();

        AdsSlientCount adsSlientCount1 = new AdsSlientCount();
        adsSlientCount1.setDt("2021-04-16");
        adsSlientCount1.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount2 = new AdsSlientCount();
        adsSlientCount2.setDt("2021-04-17");
        adsSlientCount2.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount3 = new AdsSlientCount();
        adsSlientCount3.setDt("2021-04-18");
        adsSlientCount3.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount4 = new AdsSlientCount();
        adsSlientCount4.setDt("2021-04-19");
        adsSlientCount4.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount5 = new AdsSlientCount();
        adsSlientCount5.setDt("2021-04-20");
        adsSlientCount5.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount6 = new AdsSlientCount();
        adsSlientCount6.setDt("2021-04-21");
        adsSlientCount6.setSlientCount((long) (1000+random.nextInt(500)));

        AdsSlientCount adsSlientCount7 = new AdsSlientCount();
        adsSlientCount7.setDt("2021-04-22");
        adsSlientCount7.setSlientCount((long) (1000+random.nextInt(500)));

        slientCounts.add(adsSlientCount1);
        slientCounts.add(adsSlientCount2);
        slientCounts.add(adsSlientCount3);
        slientCounts.add(adsSlientCount4);
        slientCounts.add(adsSlientCount5);
        slientCounts.add(adsSlientCount6);
        slientCounts.add(adsSlientCount7);

        ResultEntity<ArrayList<AdsSlientCount>> slientCountsEntity = ResultEntity.successWithData(slientCounts);
        modelMap.addAttribute("slientCountsEntity",slientCountsEntity);

        return "wastage_count";
    }*/

    @RequestMapping("/wastage_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsWastageCount>> getByDt(@RequestBody String dt){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        //获取数据
        int size = 7;
        ArrayList<AdsWastageCount> wastageCounts = adsWastageCountService.getByDt(preDate, size);

        ResultEntity<ArrayList<AdsWastageCount>> wastageCountsEntity = ResultEntity.successWithData(wastageCounts);

        return wastageCountsEntity;
    }


}
