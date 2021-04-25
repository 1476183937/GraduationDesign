package com.hnust.mapper;

import com.hnust.entity.AdsSourceNewCountDay;
import com.hnust.entity.vo.SourceActivityVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 各个渠道新增用户数
 */
public interface AdsSourceNewCountDayMapper {

    @Select("SELECT * FROM ads_source_new_count_day;")
    ArrayList<AdsSourceNewCountDay> queryAll();

    //根据日期获取各个渠道新增用户数
    @Select("SELECT ass.source_name source_name,t1.new_user_count count FROM ads_source ass JOIN " +
            "(SELECT * FROM ads_source_new_count_day WHERE dt=#{dt})t1 " +
            "ON ass.id = t1.source;")
    ArrayList<SourceActivityVO> queryByDt(@Param("dt")String dt);


}
