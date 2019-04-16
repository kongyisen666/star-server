package com.star.service;

import com.star.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionService {

    // 获取登陆用户
    public User getUser(HttpServletRequest request){
        if(null==request){
            return null;
        }
        HttpSession session = request.getSession();
        if(null==session){
            return null;
        }
        User user = (User)session.getAttribute("user");
        return user;
    }
}
