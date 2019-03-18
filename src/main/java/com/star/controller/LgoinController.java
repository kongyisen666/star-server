package com.star.controller;


import com.framework.util.StringUtil;
import com.star.model.AjaxReturnForm;
import com.star.model.Children;
import com.star.model.User;
import com.star.util.HttpRequest;
import io.ebean.Ebean;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/lgoin")
public class LgoinController {

    @ResponseBody
    @RequestMapping(value = "/")
    public AjaxReturnForm decodeUserInfo(String code) {
        if (code == null || code.length() == 0) {
            return new AjaxReturnForm(false,null,"code不能为空");
        }
        String openId = getOpenId(code);
        if (StringUtil.isNullOrEmpty(openId)) {
            return new AjaxReturnForm(false,null,"openid为空");
        }
        List<User> Users = Ebean.find(User.class).where().eq("openId", openId).findList();
        if (Users.size()>0){
            return new AjaxReturnForm(true,null,Users.get(0));
        }
        User user = new User();
        user.setOpenId(openId);
        user.save();
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
        String wxspSecret = "f560145ed5e6452d87da539b792a3ff4";
        //授权（必填）
        String grant_type = "authorization_code";
        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        return openid;
    }

}
