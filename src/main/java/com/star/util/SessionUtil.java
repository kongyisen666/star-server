package com.star.util;

import io.ebean.Ebean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SessionUtil {
	/**
	 * 得到登录人名称
	 * 
	 * @return
	 */
	public static String getLoginName() {
		Object obj=getSessionInfo(SessionKeys.LOGIN_USER_NAME);
		if(obj!=null){
			return obj.toString();
		}
		return "system";
	}

	// 移除session变量
	public static void removeAttr(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.removeAttribute(key);
	}
	public static RolesUtil getRolesHeler() {
		Object obj = SessionUtil.getSessionInfo(SessionKeys.LOGIN_ROLES);
		if (obj == null) {
			return null;
		}
		RolesUtil rolesHelper = (RolesUtil)obj;
		return rolesHelper;
	}

	// 设置session
	public static void setSessionInfo(String key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(key, value);
	}

	// 得到session
	public static Object getSessionInfo(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		return session.getAttribute(key);
	}
}
