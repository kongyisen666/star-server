package com.star.service;

import com.star.model.ScoreLog;
import io.ebean.Ebean;

import java.util.Date;

public class ChildrenService {

    public Boolean addScore(Integer childrenId,Integer score,String msg){
        if(null==childrenId||null == score){
            return false;
        }
        ScoreLog scoreLog = new ScoreLog();
        scoreLog.setChildrenId(childrenId);
        scoreLog.setMsg(msg);
        scoreLog.setInsertedAt(new Date());
        scoreLog.setScore(score);
        Ebean.save(scoreLog);
        String sql = "update tbl_children set score = score + :score where id = :childrenId ";
        int execute = Ebean.createSqlUpdate(sql).setParameter("score", score).setParameter("childrenId", childrenId).execute();
        if (execute > 0){
            return true;
        }
        return false;
    }
}
