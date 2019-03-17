package com.star.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/amap.properties", encoding = "UTF-8")
public class AmapConfig {

    //#高德地图Web服务
    @Value("${amap_key}")
    String amapKey = "0a783af75993e5fbe80109c6ba14d74a";
    //#地理编码接口
    @Value("${geo}")
    String geo = "https://restapi.amap.com/v3/geocode/geo";
    //#周边接口
    @Value("${around}")
    String around = "https://restapi.amap.com/v3/place/around";
    //#距离测量接口
    @Value("${distance}")
    String distance = "https://restapi.amap.com/v3/distance";
    @Value("${radius}")
    String radius = "10000";
    @Value("${keywords}")
    String keywords = "眼镜";

    public String getAmapKey() {
        return amapKey;
    }

    public void setAmapKey(String amapKey) {
        this.amapKey = amapKey;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getAround() {
        return around;
    }

    public void setAround(String around) {
        this.around = around;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
