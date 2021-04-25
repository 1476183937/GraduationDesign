package com.hnust.service;

import com.hnust.entity.AdsSlientCount;

import java.util.ArrayList;

public interface AdsSlientCountService {

    ArrayList<AdsSlientCount> queryAll();

    //获取指定日期 dt 的沉默用户数的数据
    ArrayList<AdsSlientCount> getByDt(String dt,int size);

}
