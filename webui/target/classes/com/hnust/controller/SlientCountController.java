package com.hnust.controller;


import com.hnust.entity.AdsSlientCount;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsSlientCountService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class SlientCountController {


    @Autowired
    private AdsSlientCountService adsSlientCountService;

    @RequestMapping("/slient_count.html")
    public String slient(ModelMap modelMap){

        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        int size = 7;
        ArrayList<AdsSlientCount> slientCounts = adsSlientCountService.getByDt(preDate, size);

        ResultEntity<ArrayList<AdsSlientCount>> slientCountsEntity = ResultEntity.successWithData(slientCounts);
        modelMap.addAttribute("slientCountsEntity",slientCountsEntity);

        return "slient_count";
    }

    /*@RequestMapping("/slient_count.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsSlientCount> slientCounts = new ArrayList<>();

        Random random = new Random();
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

        return "slient_count";
    }*/


    @RequestMapping("/slient_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsSlientCount>> getByDt(@RequestBody String dt){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        //获取结果条数
        int size = 7;

        //获取结果
        ArrayList<AdsSlientCount> slientCount = adsSlientCountService.getByDt(preDate, size);

        ResultEntity<ArrayList<AdsSlientCount>> slientCountEntity = ResultEntity.successWithData(slientCount);

        return slientCountEntity;
    }

}
