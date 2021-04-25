package com.hnust.controller;

import com.hnust.entity.AdsProvinceCityCountDay;
import com.hnust.entity.ResultEntity;
import com.hnust.entity.vo.ProvinceActivityVO;
import com.hnust.service.AdsProvinceCityCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 各省市活跃数据 controller
 */
@Controller
public class ProvinceCountController {

    @Autowired
    private AdsProvinceCityCountDayService adsProvinceCityCountDayService;

    @RequestMapping("/province_count.html")
    public String province(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");

        ArrayList<AdsProvinceCityCountDay> provinceActivityCount = adsProvinceCityCountDayService.getByDt(now);

        //存储海南省的各个城市的活跃数据
        ArrayList<AdsProvinceCityCountDay> hainanCityCount = new ArrayList<>();

        //key:省份名称 value:该省份活跃用户数
        HashMap<String, Long> provinceCountMap = new HashMap<>();

        //遍历计算各个省份的活跃数
        for (AdsProvinceCityCountDay provinceCityCountDay : provinceActivityCount) {
            provinceCountMap.put(provinceCityCountDay.getProvinceName(),
                    provinceCountMap.getOrDefault(provinceCityCountDay.getProvinceName(), (long) 0)+provinceCityCountDay.getActivityCount());

            if (provinceCityCountDay.getProvinceName().contains("海南")){
                //取出海南省各城市的数据
                hainanCityCount.add(provinceCityCountDay);
            }

        }

        //添加到一个集合中
        ArrayList<ProvinceActivityVO> provinceActivityVOS = new ArrayList<>();

        for (String key : provinceCountMap.keySet()) {
            ProvinceActivityVO provinceActivityVO = new ProvinceActivityVO();
            provinceActivityVO.setProvinceName(key);
            provinceActivityVO.setActivityCount(provinceCountMap.get(key));
            provinceActivityVOS.add(provinceActivityVO);
        }

        //根据活跃数进行排序
        Collections.sort(provinceActivityVOS,(x,y)-> (int) (y.getActivityCount()-x.getActivityCount()));
        ResultEntity<ArrayList<ProvinceActivityVO>> provinceActivityCountEntity = ResultEntity.successWithData(provinceActivityVOS);

        ResultEntity<ArrayList<AdsProvinceCityCountDay>> hainanCityCountEntity = ResultEntity.successWithData(hainanCityCount);

        modelMap.addAttribute("provinceActivityCountEntity",provinceActivityCountEntity);
        modelMap.addAttribute("hainanCityCountEntity",hainanCityCountEntity);

        return "province_count";
    }

    /*@RequestMapping("/province_count.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsProvinceCityCountDay> provinceActivityCount = new ArrayList<>();

        Random random = new Random();
        AdsProvinceCityCountDay adsProvinceCityCountDay1 = new AdsProvinceCityCountDay();
        adsProvinceCityCountDay1.setDt("2020-11-16");

        AdsProvinceCityCountDay adsProvinceCityCountDay2 = new AdsProvinceCityCountDay();
        AdsProvinceCityCountDay adsProvinceCityCountDay3 = new AdsProvinceCityCountDay();
        AdsProvinceCityCountDay adsProvinceCityCountDay4 = new AdsProvinceCityCountDay();
        AdsProvinceCityCountDay adsProvinceCityCountDay5 = new AdsProvinceCityCountDay();
        AdsProvinceCityCountDay adsProvinceCityCountDay6 = new AdsProvinceCityCountDay();
        AdsProvinceCityCountDay adsProvinceCityCountDay7 = new AdsProvinceCityCountDay();

        ResultEntity<ArrayList<AdsProvinceCityCountDay>> provinceActivityCountEntity = ResultEntity.successWithData(provinceActivityCount);

        modelMap.addAttribute("provinceActivityCountEntity",provinceActivityCountEntity);

        return "province_count";
    }*/

    //根据日期查询当日的省市活跃数据
    @RequestMapping("/province_count")
    @ResponseBody
    public ResultEntity<ArrayList<ProvinceActivityVO>> getByDt(@RequestBody String dt){

        ArrayList<AdsProvinceCityCountDay> provinceActivityCount = adsProvinceCityCountDayService.getByDt(dt);

        HashMap<String, Long> provinceCountMap = new HashMap<>();

        for (AdsProvinceCityCountDay provinceCityCountDay : provinceActivityCount) {
            provinceCountMap.put(provinceCityCountDay.getProvinceName(),
                    provinceCountMap.getOrDefault(provinceCityCountDay.getProvinceName(), (long) 0)+provinceCityCountDay.getActivityCount());

        }

        ArrayList<ProvinceActivityVO> provinceActivityVOS = new ArrayList<>();

        for (String key : provinceCountMap.keySet()) {
            ProvinceActivityVO provinceActivityVO = new ProvinceActivityVO();
            provinceActivityVO.setProvinceName(key);
            provinceActivityVO.setActivityCount(provinceCountMap.get(key));
            provinceActivityVOS.add(provinceActivityVO);
        }

        Collections.sort(provinceActivityVOS,(x,y)-> (int) (y.getActivityCount()-x.getActivityCount()));

        ResultEntity<ArrayList<ProvinceActivityVO>> provinceActivityCountEntity = ResultEntity.successWithData(provinceActivityVOS);

        return provinceActivityCountEntity;
    }

    //根据日期和省份查询当日的省市活跃数据
    @RequestMapping("/city_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsProvinceCityCountDay>> getByProvinceAndDt(@RequestParam("province") String province, @RequestParam("dt") String dt){

        ArrayList<AdsProvinceCityCountDay> cityActivityCount = adsProvinceCityCountDayService.getByProvinceAndDt(province, dt);

        Collections.sort(cityActivityCount,(x,y)->y.getActivityCount()-x.getActivityCount());

        ResultEntity<ArrayList<AdsProvinceCityCountDay>> cityActivityCountEntity = ResultEntity.successWithData(cityActivityCount);

        return cityActivityCountEntity;
    }

}
