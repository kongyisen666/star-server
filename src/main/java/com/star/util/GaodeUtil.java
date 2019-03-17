package com.star.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.framework.util.StringUtil;
import com.star.config.AmapConfig;
import com.star.config.ProjectConfig;
import com.star.service.SpringContextUtils;

import java.util.*;

/**
 * 高德地图工具类
 */
public class GaodeUtil {

    static  AmapConfig amapConfig = (AmapConfig) SpringContextUtils.getBeanByClass(AmapConfig.class);
   static String  gaodeKey= amapConfig.getAmapKey();
    /**
     *
     * 地址解析经纬度
     * @param address 详细地址：省、市、区、具体地址
     * @return 经纬度 坐标对
     */
    public static String geo(String address) {
        if (StringUtil.isNullOrEmpty(address)){
            return null;
        }
        String geo = amapConfig.getGeo();
        String param = "address=" + address + "&output=JSON&key=" + gaodeKey;
        String location = "";
        String res = HttpUtilSalter.sendPost(geo, param);
        JSONObject resObject = JSONObject.parseObject(res);
        String status = resObject.getString("status");
        if ("1".equals(status)) {
            location = resObject.getJSONArray("geocodes").getJSONObject(0).getString("location");
        }
        return location;

    }

    /**
     *
     * @param location
     * @return
     */
    public static List<String> around(String location) {
        String around = amapConfig.getAround();

        String radius = amapConfig.getRadius();
        String keywords = amapConfig.getKeywords();
        String param = "radius=" + radius + "&keywords=" + keywords + "&location=" + location + "&key=" + gaodeKey;
        List<String> list = new ArrayList<>();
        String res = HttpUtilSalter.sendPost(around, param);
        JSONObject resObject = JSONObject.parseObject(res);
        String status = resObject.getString("status");
        if ("1".equals(status)) {
            JSONArray pois = resObject.getJSONArray("pois");
            for (int i = 0; i < pois.size(); i++) {
                list.add(pois.getJSONObject(i).getString("name"));
            }
        }
        return list;
    }

    /**
     * @param origins     出发点,100个坐标对 例:116.481028,39.989643|114.481028,39.989643
     * @param destination 目的地  例:117.500244, 40.417801
     * @return 返回多个出发点与目的地的直线距离
     */
    public static Map distance(String[] origins, String destination) {
        Map retMap = new HashMap();
        retMap.put("success", false);
        if (StringUtil.isNullOrEmpty(destination)&&origins.length==0){
            retMap.put("msg","没有经纬度");
            return retMap;
        }
        String url = amapConfig.getDistance();
        String param = "origins=" +  String.join("\\|", origins)+ "&destination=" + destination + "&key=" + gaodeKey + "&type=0";
        String res = HttpUtilSalter.sendPost(url, param);
        JSONObject resObject = JSONObject.parseObject(res);
        String status = resObject.getString("status");
        if ("0".equals(status)) {
            retMap.put("msg", resObject.getString("info"));
            return retMap;
        }
        retMap.put("success", true);
        retMap.put("data", resObject.getJSONArray("results"));
        return retMap;
    }

    /**
     * @param origins
     * @param destination
     * @return 距离目的地最近的出发点
     */
    public static Map minDistance(String[] origins, String destination) {
        Map retMap = new HashMap();
        retMap.put("success", false);
        if (StringUtil.isNullOrEmpty(destination)&&origins.length==0){
            retMap.put("msg", "没有经纬度");
            return retMap;
        }
        Map res = distance(origins, destination);
        List<JSONObject> list = JSONArray.parseArray(res.get("data").toString(), JSONObject.class);
        if ("false".equals(res.get("success").toString()) || list.size() == 0) {
            retMap.put("msg", "接口请求失败，或数据异常");
            return retMap;
        }
        Collections.sort(list, new Comparator("distance"));
        retMap.put("success", true);
        retMap.put("data", list.get(0));
        return retMap;
    }


}
