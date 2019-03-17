package com.star.util;

import java.util.List;

import com.framework.util.StringUtil;

public class RolesUtil {
	private List<String> roles;
	public RolesUtil(List<String> roles) {
		this.roles=roles;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * 是否有门店
	 * @return
	 */
	public Boolean hasStore(){
		return hasEngName("store");
	}
	/**
	 * 是否有游客
	 * @return
	 */
	public Boolean hasTourist(){ return hasEngName("Tourist");
	}
	/**
	 * 
	 * @return
	 */
	public Boolean hasStoreUser(){
		return hasEngName("storeUser");
	}
	/**
	 * 是否有批发商
	 * @return
	 */
	public Boolean hasDealer(){
		return hasEngName("dealer");
	}
	/**
	 * 是否有爱尔康销售
	 * @return
	 */
	public Boolean hasSale(){
		return hasEngName("alconSell");
	}
	
	/**
	 * 是否有品牌经理
	 * 
	 * @return
	 */
	public Boolean hasBrandManager() {
		return hasEngName("brandManager");
	}
		
	/**
	 * 是否有这个角色
	 * @param engName
	 * @return
	 */
	private Boolean hasEngName(String engName){
		if(roles==null){
			return false;
		}
		if(StringUtil.isNullOrEmpty(engName)){
			return false;
		}
		for (String role : roles) {
			if(engName.equals(role)){
				return true;
			}
		}
		return false;
	}
}
