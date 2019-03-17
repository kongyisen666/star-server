package com.star.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.service.SMSService;
import com.star.model.AjaxReturnForm;


@RestController
@RequestMapping(value = "/system/auth_code")
public class SystemAuthCodeController{
	/**
	 * @name 验证码================生成
	 */
	@RequestMapping(value = "/get_auth_code", method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturnForm ajaxVerificationCode(HttpServletRequest request, HttpServletResponse response) {
		AjaxReturnForm from =new AjaxReturnForm();
		String phone = request.getParameter("phoneNumber");
		String authCode= (int)(Math.random()*(9999-1000+1))+1000+"";
		sendCode(phone,authCode);
		System.out.println(authCode);
		HttpSession session = request.getSession(); 
		session.setAttribute("verificationCode", phone+"&"+authCode);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		session.setAttribute(phone+"&"+authCode, sdf.format(new Date()));
		from.success=true;
	 	 return from;
	}
	
	public void sendCode(String phone,String code){
	    String templates ="auth_code";
	    Map<String,String> param = new HashMap<>();
	    param.put("code",code);
	    try {
	        SMSService smsService=new SMSService();
	        smsService.saveSMSTask(templates,param,null,phone);
	    } catch (Exception e) {
	        System.out.println("短信发送异常");
	        e.printStackTrace();
	    }
	}
	
}
