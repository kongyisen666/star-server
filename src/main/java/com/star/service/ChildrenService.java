package com.star.service;

import com.framework.util.ModelUtil;
import com.star.model.Children;
import com.star.model.ScoreLog;
import io.ebean.Ebean;

import java.util.Date;

public class ChildrenService {


    // 新增或删除
    public void addOrUpdate(Children children){
        if (null == children){
            return;
        }
        if(null==children.getId()){
            children.save();
        }
        if(null!=children.getId()){
            Children c = ModelUtil.copyModel(children);
            Ebean.update(c);
        }
    }

    //增加分数
    public ScoreLog addScore(Integer childrenId,Integer score,String msg){
        if(null==childrenId||null == score){
            return null;
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
            return scoreLog;
        }
        return null;
    }
}
