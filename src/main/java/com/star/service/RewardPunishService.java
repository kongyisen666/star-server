package com.star.service;

import com.star.model.RewardPunish;
import io.ebean.Ebean;

import java.util.List;

public class RewardPunishService {

    // 根据类型查询
    public List<RewardPunish> searchByType(Integer type){
        if (type == null){
            return null;
        }
        List<RewardPunish> list = Ebean.find(RewardPunish.class).where().eq("deleted", 0).eq("type", type).findList();
        return list;
    }

}
