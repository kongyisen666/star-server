package com.star.controller;


import com.framework.util.ModelUtil;
import com.star.model.Children;
import com.star.model.AjaxReturnForm;
import com.star.model.ScoreLog;
import com.star.model.User;
import com.star.service.ChildrenService;
import com.star.util.SessionUtil;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("children")
public class ChildrenController {


    @ResponseBody
    @RequestMapping(value = "/get_children")
    public AjaxReturnForm getChildren(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return new AjaxReturnForm(false,"请重新登陆",null);
        }
        List<Children> list = Ebean.find(Children.class).where().eq("userId", user.getId()).orderBy("updatedAt desc").findList();
        if (list.size()>0){
            return new AjaxReturnForm(true,null,list.get(0));
        }
        return new AjaxReturnForm(false,"没有添加孩子信息",null);
    }


    @ResponseBody
    @RequestMapping(value = "/add_children")
    public AjaxReturnForm addChildren(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        Children children = (Children) ModelUtil.toModel(map, Children.class);
        if(null==children){
            return new AjaxReturnForm(false,null,"新增失败");
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(null==user){
            return new AjaxReturnForm(false,null,"重新登陆");
        }
        children.setUserId(user.getId());
        children.save();
        user.setType(1);
        Ebean.update(user);
        return new AjaxReturnForm(true,null,user);
    }

    @ResponseBody
    @RequestMapping(value = "/add_score")
    public AjaxReturnForm addScore(@RequestBody Map<String, String> map) {
        Integer childrenId = map.get("childrenId")==null? null:Integer.parseInt( map.get("childrenId"));
        Integer score = map.get("childrenId") == null? null:Integer.parseInt( map.get("score"));
        String msg = map.get("msg");
        if (null==childrenId){
            return new AjaxReturnForm(false,"孩子编号为空",null);
        }
        List<Children> childrens = Ebean.find(Children.class).where().eq("id", childrenId).findList();
        if(childrens.size()==0){
            return new AjaxReturnForm(false,"未找到对应孩子",null);
        }
        ChildrenService childrenService = new ChildrenService();
        Boolean success = childrenService.addScore(childrenId, score, msg);
        if(success){
            return new AjaxReturnForm(true,null,null);
        }
        return new AjaxReturnForm(false,"分数增加失败",null);
    }

}
