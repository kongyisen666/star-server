package com.star.model;

import java.util.HashMap;
import java.util.Map;

public class AjaxReturnForm {
	public Integer code;
	public Boolean success=false;
	public String msg;
	public Map<String, Object> object = new HashMap<>();
	public Boolean needLogin;

	public AjaxReturnForm(){

	}

	public AjaxReturnForm(Boolean success,String msg,Object object){
		this.success=success;
		this.msg=msg;
		this.object.put("object",object);
	}

	public AjaxReturnForm returnErrorMsg(String msg){
		this.success=false;
		this.msg=msg;
		return this;
	}

	public AjaxReturnForm addSuccess(Object object){
		this.success=true;
		this.object.put("object",object);
		return this;
	}

	public Boolean getNeedLogin() {
		return needLogin;
	}
	public void setNeedLogin(Boolean needLogin) {
		this.needLogin = needLogin;
	}
	public Map<String, Object> getObject() {
		return object;
	}
	public void setObject(Map<String, Object> object) {
		this.object = object;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
