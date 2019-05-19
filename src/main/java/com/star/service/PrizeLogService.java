package com.star.service;

import com.framework.util.ModelUtil;
import com.star.model.Prize;
import com.star.model.PrizeLog;
import io.ebean.Ebean;

import java.util.Date;
import java.util.List;

public class PrizeLogService {

    public void AddPrizeLog(PrizeLog prizeLog) {
        prizeLog.setInsertedAt(new Date());
        Ebean.save(prizeLog);
    }


}
