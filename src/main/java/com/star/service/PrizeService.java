package com.star.service;

import com.framework.util.ModelUtil;
import com.star.model.Prize;
import io.ebean.Ebean;

import java.util.List;

public class PrizeService {

    public void setOrUpdate(Prize prize) {
        if (null == prize.getId()) {
            Ebean.save(prize);
        } else {
            Prize prize1 = ModelUtil.copyModel(prize);
            Ebean.update(prize1);
        }
    }

    public Prize searchPrize(String userId) {
        List<Prize> prizes = Ebean.find(Prize.class).where().eq("userId", userId).findList();
        return prizes.get(0);
    }

}
