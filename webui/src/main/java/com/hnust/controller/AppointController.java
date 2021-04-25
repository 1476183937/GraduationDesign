package com.hnust.controller;

import com.hnust.entity.*;
import com.hnust.service.AdsAppointmentCountDayService;
import com.hnust.service.AdsDealCountDayService;
import com.hnust.service.AdsLookCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 预约数controller
 */
@Controller
public class AppointController {

    @Autowired
    private AdsAppointmentCountDayService adsAppointmentCountDayService;
    @Autowired
    private AdsLookCountDayService adsLookCountDayService;
    @Autowired
    private AdsDealCountDayService adsDealCountDayService;

    @RequestMapping("/appoint_look_deal_count.html")
    public String appoint(ModelMap modelMap){

        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        int size = 7;
        //获取预约数据
        ArrayList<AdsAppointmentCountDay> appointmentCount = adsAppointmentCountDayService.getByDt(preDate, size);
        ResultEntity<ArrayList<AdsAppointmentCountDay>> appointmentCountEntity = ResultEntity.successWithData(appointmentCount);

        //获取带看数据
        ArrayList<AdsLookCountDay> lookCount = adsLookCountDayService.getByDt(preDate, size);
        ResultEntity<ArrayList<AdsLookCountDay>> lookCountEntity = ResultEntity.successWithData(lookCount);

        //获取成交数据
        ArrayList<AdsDealCountDay> dealCount = adsDealCountDayService.getByDt(preDate, size);
        ResultEntity<ArrayList<AdsDealCountDay>> dealCountEntity = ResultEntity.successWithData(dealCount);

        modelMap.addAttribute("appointmentCountEntity",appointmentCountEntity);
        modelMap.addAttribute("lookCountEntity",lookCountEntity);
        modelMap.addAttribute("dealCountEntity",dealCountEntity);

        return "appoint_look_deal_count";
    }


    /*@RequestMapping("/appoint_look_deal_count.html")
    public String test(ModelMap modelMap){

        Random random = new Random();

        //获取预约数据
        ArrayList<AdsAppointmentCountDay> appointmentCount = new ArrayList<>();
        AdsAppointmentCountDay adsAppointmentCountDay1 = new AdsAppointmentCountDay();
        adsAppointmentCountDay1.setDt("2021-04-16");
        adsAppointmentCountDay1.setAppointmentCount((long) (1000+random.nextInt(500)));

        AdsAppointmentCountDay adsAppointmentCountDay2 = new AdsAppointmentCountDay();
        adsAppointmentCountDay2.setDt("2021-04-17");
        adsAppointmentCountDay2.setAppointmentCount((long) (1000+random.nextInt(500)));
        AdsAppointmentCountDay adsAppointmentCountDay3 = new AdsAppointmentCountDay();
        adsAppointmentCountDay3.setDt("2021-04-18");
        adsAppointmentCountDay3.setAppointmentCount((long) (1000+random.nextInt(500)));
        AdsAppointmentCountDay adsAppointmentCountDay4 = new AdsAppointmentCountDay();
        adsAppointmentCountDay4.setDt("2021-04-19");
        adsAppointmentCountDay4.setAppointmentCount((long) (1000+random.nextInt(500)));
        AdsAppointmentCountDay adsAppointmentCountDay5 = new AdsAppointmentCountDay();
        adsAppointmentCountDay5.setDt("2021-04-20");
        adsAppointmentCountDay5.setAppointmentCount((long) (1000+random.nextInt(500)));
        AdsAppointmentCountDay adsAppointmentCountDay6 = new AdsAppointmentCountDay();
        adsAppointmentCountDay6.setDt("2021-04-21");
        adsAppointmentCountDay6.setAppointmentCount((long) (1000+random.nextInt(500)));
        AdsAppointmentCountDay adsAppointmentCountDay7 = new AdsAppointmentCountDay();
        adsAppointmentCountDay7.setDt("2021-04-22");
        adsAppointmentCountDay7.setAppointmentCount((long) (1000+random.nextInt(500)));

        appointmentCount.add(adsAppointmentCountDay1);
        appointmentCount.add(adsAppointmentCountDay2);
        appointmentCount.add(adsAppointmentCountDay3);
        appointmentCount.add(adsAppointmentCountDay4);
        appointmentCount.add(adsAppointmentCountDay5);
        appointmentCount.add(adsAppointmentCountDay6);
        appointmentCount.add(adsAppointmentCountDay7);

        ResultEntity<ArrayList<AdsAppointmentCountDay>> appointmentCountEntity = ResultEntity.successWithData(appointmentCount);

        //获取带看数据
        ArrayList<AdsLookCountDay> lookCount = new ArrayList<>();
        AdsLookCountDay adsLookCountDay1 = new AdsLookCountDay();
        adsLookCountDay1.setDt("2021-04-16");
        adsLookCountDay1.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay2 = new AdsLookCountDay();
        adsLookCountDay2.setDt("2021-04-17");
        adsLookCountDay2.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay3 = new AdsLookCountDay();
        adsLookCountDay3.setDt("2021-04-18");
        adsLookCountDay3.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay4 = new AdsLookCountDay();
        adsLookCountDay4.setDt("2021-04-19");
        adsLookCountDay4.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay5 = new AdsLookCountDay();
        adsLookCountDay5.setDt("2021-04-20");
        adsLookCountDay5.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay6 = new AdsLookCountDay();
        adsLookCountDay6.setDt("2021-04-21");
        adsLookCountDay6.setLookCount((long) (1000+random.nextInt(500)));
        AdsLookCountDay adsLookCountDay7 = new AdsLookCountDay();
        adsLookCountDay7.setDt("2021-04-22");
        adsLookCountDay7.setLookCount((long) (1000+random.nextInt(500)));

        lookCount.add(adsLookCountDay1);
        lookCount.add(adsLookCountDay2);
        lookCount.add(adsLookCountDay3);
        lookCount.add(adsLookCountDay4);
        lookCount.add(adsLookCountDay5);
        lookCount.add(adsLookCountDay6);
        lookCount.add(adsLookCountDay7);
        ResultEntity<ArrayList<AdsLookCountDay>> lookCountEntity = ResultEntity.successWithData(lookCount);

        //获取成交数据
        ArrayList<AdsDealCountDay> dealCount = new ArrayList<>();
        AdsDealCountDay adsDealCountDay1 = new AdsDealCountDay();
        adsDealCountDay1.setDt("2021-04-16");
        adsDealCountDay1.setDealCount(1000+random.nextInt(500));
        adsDealCountDay1.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay2 = new AdsDealCountDay();
        adsDealCountDay2.setDt("2021-04-17");
        adsDealCountDay2.setDealCount(1000+random.nextInt(500));
        adsDealCountDay2.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay3 = new AdsDealCountDay();
        adsDealCountDay3.setDt("2021-04-18");
        adsDealCountDay3.setDealCount(1000+random.nextInt(500));
        adsDealCountDay3.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay4 = new AdsDealCountDay();
        adsDealCountDay4.setDt("2021-04-19");
        adsDealCountDay4.setDealCount(1000+random.nextInt(500));
        adsDealCountDay4.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay5 = new AdsDealCountDay();
        adsDealCountDay5.setDt("2021-04-20");
        adsDealCountDay5.setDealCount(1000+random.nextInt(500));
        adsDealCountDay5.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay6 = new AdsDealCountDay();
        adsDealCountDay6.setDt("2021-04-21");
        adsDealCountDay6.setDealCount(1000+random.nextInt(500));
        adsDealCountDay6.setGvm((long) (30000+random.nextInt(50000)));
        AdsDealCountDay adsDealCountDay7 = new AdsDealCountDay();
        adsDealCountDay7.setDt("2021-04-22");
        adsDealCountDay7.setDealCount(1000+random.nextInt(500));
        adsDealCountDay7.setGvm((long) (30000+random.nextInt(50000)));
        dealCount.add(adsDealCountDay1);
        dealCount.add(adsDealCountDay2);
        dealCount.add(adsDealCountDay3);
        dealCount.add(adsDealCountDay4);
        dealCount.add(adsDealCountDay5);
        dealCount.add(adsDealCountDay6);
        dealCount.add(adsDealCountDay7);

        ResultEntity<ArrayList<AdsDealCountDay>> dealCountEntity = ResultEntity.successWithData(dealCount);

        modelMap.addAttribute("appointmentCountEntity",appointmentCountEntity);
        modelMap.addAttribute("lookCountEntity",lookCountEntity);
        modelMap.addAttribute("dealCountEntity",dealCountEntity);

        return "appoint_look_deal_count";
    }*/

    @RequestMapping("/appoint_look_deal_count")
    @ResponseBody
    public ResultEntity<AppointLookDeal> getByDt(@RequestBody String dt, ModelMap modelMap){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        int size = 7;

        //获取预约数据
        ArrayList<AdsAppointmentCountDay> appointmentCount = adsAppointmentCountDayService.getByDt(preDate, size);

        //获取带看数据
        ArrayList<AdsLookCountDay> lookCount = adsLookCountDayService.getByDt(preDate, size);

        //获取成交数据
        ArrayList<AdsDealCountDay> dealCount = adsDealCountDayService.getByDt(preDate, size);

        AppointLookDeal appointLookDeal = new AppointLookDeal();
        appointLookDeal.setAppointmentCountDayList(appointmentCount);
        appointLookDeal.setDealCountDayList(dealCount);
        appointLookDeal.setLookCountDayList(lookCount);

        ResultEntity<AppointLookDeal> appointLookDealEntity = ResultEntity.successWithData(appointLookDeal);

        return appointLookDealEntity;
    }

    @RequestMapping("/gvm")
    @ResponseBody
    public ResultEntity<ArrayList<AdsDealCountDay>> gvm(@RequestBody String dt){

        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<AdsDealCountDay> dealCount = adsDealCountDayService.getByDt(preDate, 7);
        ResultEntity<ArrayList<AdsDealCountDay>> dealCountEntity = ResultEntity.successWithData(dealCount);

        return dealCountEntity;
    }

}
