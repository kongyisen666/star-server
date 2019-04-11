package com.star.controller;


import com.framework.util.StringUtil;
import com.star.model.AjaxReturnForm;
import com.star.model.Children;
import com.star.model.User;
import com.star.util.HttpRequest;
import com.star.util.SessionUtil;
import io.ebean.Ebean;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @ResponseBody
    @RequestMapping(value = "/")
    public AjaxReturnForm decodeUserInfo(HttpServletRequest request, String code) {
        if (code == null || code.length() == 0) {
            return new AjaxReturnForm(false,null,"code不能为空");
        }
        String openId = getOpenId(code);
        if (StringUtil.isNullOrEmpty(openId)) {
            return new AjaxReturnForm(false,null,"openid为空");
        }
        List<User> users = Ebean.find(User.class).where().eq("openId", openId).findList();
        HttpSession session = request.getSession();
        if (users.size()>0){
            User user = users.get(0);
            session.setAttribute("user",user);
            return new AjaxReturnForm(true,null,user);
        }
        User user = new User();
        user.setOpenId(openId);
        user.save();
        session.setAttribute("user",user);
        return new AjaxReturnForm(true,null,user);
    }


    /**
     * 获取Openid
     * @param code 小程序code
     * @return
     */
    private String getOpenId(String code){
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wx3c3155c6b348d0b0";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "60a1de54645691d0153361890b94d31c";
        //授权（必填）
        String grant_type = "authorization_code";
        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        return openid;
    }

}
