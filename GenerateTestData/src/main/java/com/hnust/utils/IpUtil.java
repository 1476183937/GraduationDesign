package com.hnust.utils;

import com.hnust.entity.RegionDetail;
import org.apache.commons.lang.StringUtils;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

import java.io.File;
import java.lang.reflect.Method;


public class IpUtil {

    public static String getCityInfo(String ip) {
//        db文件下载地址，https://gitee.com/lionsoul/ip2region/tree/master/data 下载下来后解压，db文件在data目录下

        String dbPath ="GenerateTestData/data/ip2region.db";
        File file = new File(dbPath);
        if (file.exists() == false) {
            System.out.println("Error: Invalid ip2region.db file");
        }
        //查询算法 B-tree
        int algorithm = DbSearcher.BTREE_ALGORITHM;
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
                default:
                    break;
            }
            if (Util.isIpAddress(ip) == false) {
                System.out.println("Error: Invalid ip address");
            }
            DataBlock dataBlock = (DataBlock) method.invoke(searcher, ip);
            return dataBlock.getRegion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: getCityInfo error";
    }

    private RegionDetail analysisAddress(String ip) {

        String ipInfo = IpUtil.getCityInfo(ip);
        //国家|大区|省份|城市|运营商
        String[] splitIpString = ipInfo.split("\\|");

        RegionDetail regionDetail = new RegionDetail();
        regionDetail.setRealIp(ip);

        regionDetail.setCountry(StringUtils.isNotBlank(splitIpString[0]) ? splitIpString[0] : "");

        regionDetail.setProvince(StringUtils.isNotBlank(splitIpString[2]) ? splitIpString[2] : "");
        regionDetail.setCity(StringUtils.isNotBlank(splitIpString[3]) ? splitIpString[3] : "");
        regionDetail.setOperator(StringUtils.isNotBlank(splitIpString[4]) ? splitIpString[4] : "");
        return regionDetail;

    }

    public static void main(String[] args) {
        //或者使用接口：http://api.map.baidu.com/location/ip?&ak=lGhonqkkoUGZurajdlpL1QqciA215kkq&ip=111.8.72.43&coor=bd09ll
        IpUtil ipUtil = new IpUtil();
        RegionDetail regionDetail = ipUtil.analysisAddress("111.8.72.43");
        System.out.println(regionDetail);
    }

}
