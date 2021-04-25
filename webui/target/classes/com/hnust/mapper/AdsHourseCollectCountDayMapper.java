package com.hnust.mapper;

import com.hnust.entity.AdsHourseCollectCountDay;
import com.hnust.entity.vo.CollectCountVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日的房屋收藏数
 */
public interface AdsHourseCollectCountDayMapper {

    @Select("SELECT * FROM ads_hourse_collect_count_day;")
    ArrayList<AdsHourseCollectCountDay> queryAll();


    //根据日期获取最近几天的房屋收藏数
    @Select("SELECT t1.dt,SUM(hccd.collect_count) collect_count FROM ads_hourse_collect_count_day hccd " +
            "JOIN" +
            "(" +
            "SELECT dt FROM ads_hourse_collect_count_day GROUP BY dt HAVING dt>=#{dt} LIMIT #{size} " +
            ")t1 ON hccd.dt = t1.dt " +
            "GROUP BY dt;")
    ArrayList<CollectCountVO> queryByDt(@Param("dt")String dt,@Param("size")int size);

    //获取日期 dt 那天收藏数前几的房屋
    @Select("SELECT * FROM ads_hourse_collect_count_day WHERE dt=#{dt} ORDER BY collect_count DESC LIMIT #{size};")
    ArrayList<AdsHourseCollectCountDay> queryCollectCountByDt(@Param("dt")String dt,@Param("size")int size);

}
