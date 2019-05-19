package com.star.controller;

import com.star.model.AjaxReturnForm;
import com.star.model.User;
import com.star.service.UserService;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 激活用户/取消激活
     *
     * @param map
     * @return
     */
    @RequestMapping("/activation")
    @ResponseBody
    public AjaxReturnForm activation(@RequestBody Map<String, Integer> map) {
        Integer userId = map.get("userId");
        Integer state = map.get("state");
        if (null == state || null == userId) {
            return new AjaxReturnForm().returnErrorMsg("操作失败");
        }
        User user = Ebean.find(User.class).where().eq("id", userId).findOne();
        user.setState(state);
        Ebean.update(user);
        return new AjaxReturnForm(true, null, null);
    }

    /**
     * 查詢所有用戶
     *
     * @return
     */
    @RequestMapping("/search_list")
    @ResponseBody
    public AjaxReturnForm searchList() {
        UserService userService = new UserService();
        List<User> users = userService.searchList();
        return new AjaxReturnForm().addSuccess(users);
    }

}
