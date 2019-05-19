package com.star.service;

import com.framework.util.ModelUtil;
import com.star.model.Prize;
import io.ebean.Ebean;
import org.apache.shiro.util.CollectionUtils;

import java.util.Collections;
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
        if(CollectionUtils.isEmpty(prizes)){
            return new Prize();
        }
        return prizes.get(0);
    }
}
