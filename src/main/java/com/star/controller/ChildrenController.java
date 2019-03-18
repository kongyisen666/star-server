package com.star.controller;


import com.star.model.Children;
import com.star.model.AjaxReturnForm;
import com.star.model.User;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("children")
public class ChildrenController {

    /**
     * 根据ID查询
     */
    @RequestMapping("searchById")
    @ResponseBody
    public AjaxReturnForm searchById(){
        Children children= new Children();
        children.setAge(13);
        Ebean.save(children);
        return new AjaxReturnForm(true,null,null);
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
    @RequestMapping(value = "/get_children")
    public String getChildren(String openid) {
        System.out.println(openid);
        return openid;
    }


}
