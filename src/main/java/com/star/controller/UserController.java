package com.star.controller;

import com.star.model.AjaxReturnForm;
import com.star.model.User;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 激活用户
     * @param userId
     * @return
     */
    public AjaxReturnForm activation(Integer userId){
        User user = Ebean.find(User.class).where().eq("id", userId).findOne();
        user.setType(1);
        Ebean.update(user);
        return new AjaxReturnForm(true,null,user);
    }

}
