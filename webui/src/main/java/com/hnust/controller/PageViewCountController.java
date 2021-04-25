package com.hnust.controller;


import com.hnust.entity.AdsUrlCount;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsUrlCountService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 每日的url浏览次数统计 controller
 */
@Controller
public class PageViewCountController {

    @Autowired
    private AdsUrlCountService adsUrlCountService;

    @RequestMapping("/page_view_count.html")
    public String pageView(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");

        int size = 10;
        ArrayList<AdsUrlCount> urlCounts = adsUrlCountService.getByDt(now, size);

        ResultEntity<ArrayList<AdsUrlCount>> urlCountsEntity = ResultEntity.successWithData(urlCounts);
        modelMap.addAttribute("urlCountsEntity",urlCountsEntity);

        return "page_view_count";
    }

    /*@RequestMapping("/page_view_count.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsUrlCount> urlCounts = new ArrayList<>();
        Random random = new Random();

        AdsUrlCount adsUrlCount1 = new AdsUrlCount();
        adsUrlCount1.setDt("2021-04-22");
        adsUrlCount1.setUrl("www.baidu.com1");
        adsUrlCount1.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount2 = new AdsUrlCount();
        adsUrlCount2.setDt("2021-04-22");
        adsUrlCount2.setUrl("www.baidu.com2");
        adsUrlCount2.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount3 = new AdsUrlCount();
        adsUrlCount3.setDt("2021-04-22");
        adsUrlCount3.setUrl("www.baidu.com3");
        adsUrlCount3.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount4 = new AdsUrlCount();
        adsUrlCount4.setDt("2021-04-22");
        adsUrlCount4.setUrl("www.baidu.com4");
        adsUrlCount4.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount5 = new AdsUrlCount();
        adsUrlCount5.setDt("2021-04-22");
        adsUrlCount5.setUrl("www.baidu.com5");
        adsUrlCount5.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount6 = new AdsUrlCount();
        adsUrlCount6.setDt("2021-04-22");
        adsUrlCount6.setUrl("www.baidu.com6");
        adsUrlCount6.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount7 = new AdsUrlCount();
        adsUrlCount7.setDt("2021-04-22");
        adsUrlCount7.setUrl("www.baidu.com7");
        adsUrlCount7.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount8 = new AdsUrlCount();
        adsUrlCount8.setDt("2021-04-22");
        adsUrlCount8.setUrl("www.baidu.com8");
        adsUrlCount8.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount9 = new AdsUrlCount();
        adsUrlCount9.setDt("2021-04-22");
        adsUrlCount9.setUrl("www.baidu.com9");
        adsUrlCount9.setUrlCount((long) (1000+random.nextInt(500)));

        AdsUrlCount adsUrlCount10 = new AdsUrlCount();
        adsUrlCount10.setDt("2021-04-22");
        adsUrlCount10.setUrl("www.baidu.com10");
        adsUrlCount10.setUrlCount((long) (1000+random.nextInt(500)));

        urlCounts.add(adsUrlCount1);
        urlCounts.add(adsUrlCount2);
        urlCounts.add(adsUrlCount3);
        urlCounts.add(adsUrlCount4);
        urlCounts.add(adsUrlCount5);
        urlCounts.add(adsUrlCount6);
        urlCounts.add(adsUrlCount7);
        urlCounts.add(adsUrlCount8);
        urlCounts.add(adsUrlCount9);
        urlCounts.add(adsUrlCount10);

        ResultEntity<ArrayList<AdsUrlCount>> urlCountsEntity = ResultEntity.successWithData(urlCounts);
        modelMap.addAttribute("urlCountsEntity",urlCountsEntity);

        return "page_view_count";
    }*/

    @RequestMapping("/url_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsUrlCount>> getByDt(@RequestBody String dt){

        int size = 10;
        ArrayList<AdsUrlCount> urlCount = adsUrlCountService.getByDt(dt, size);

        ResultEntity<ArrayList<AdsUrlCount>> urlCountsEntity = ResultEntity.successWithData(urlCount);

        return urlCountsEntity;
    }

}
