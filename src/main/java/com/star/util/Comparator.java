package com.star.util;


import com.alibaba.fastjson.JSONObject;


public class Comparator implements java.util.Comparator<JSONObject> {

    String param;
    public Comparator(String param){
        this.param=param;
    }
    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        Integer key1 = o1.getInteger(param);
        Integer key2 = o2.getInteger(param);
        return key1-key2;
    }


}
