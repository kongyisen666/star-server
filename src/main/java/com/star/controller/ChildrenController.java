package com.star.controller;


import com.star.model.Children;
import com.star.model.AjaxReturnForm;
import com.star.model.ScoreLog;
import com.star.model.User;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("children")
public class ChildrenController {


    @ResponseBody
    @RequestMapping(value = "/get_children")
    public AjaxReturnForm getChildren(String userId) {
        List<Children> list = Ebean.find(Children.class).where().eq("userId", userId).findList();
        if (list.size()>0){
            return new AjaxReturnForm(true,null,list.get(0));
        }
        return new AjaxReturnForm(false,"没有添加孩子信息",null);
    }


    @ResponseBody
    @RequestMapping(value = "/add_children")
    public AjaxReturnForm addChildren(Children children) {
        if(null==children){
            return new AjaxReturnForm(false,null,"新增失败");
        }
        User user = Ebean.find(User.class).where().eq("id", children.getUserId()).findOne();
        children.save();
        user.setId(Integer.parseInt(children.getUserId()));
        user.setType(1);
        Ebean.update(user);
        return new AjaxReturnForm(true,null,user);
    }

    @ResponseBody
    @RequestMapping(value = "/add_score")
    public AjaxReturnForm addScore(Integer childrenId,String msg,Integer score) {
        if (null==childrenId){
            return new AjaxReturnForm(false,"孩子编号为空",null);
        }
        Children children = Ebean.find(Children.class, childrenId);
        children.setScore(children.getScore()+score);
        Ebean.update(children);
        ScoreLog scoreLog = new ScoreLog();
        scoreLog.setChildrenId(childrenId);
        scoreLog.setMsg(msg);
        scoreLog.setScore(score);
        Ebean.save(scoreLog);
        return new AjaxReturnForm(true,null,null);
    }

}
