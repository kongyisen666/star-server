package com.star.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/project.properties", encoding = "UTF-8")
public class ProjectConfig {
	
	@Value("${upload_fild_dir}")
	private String uploadFildDir;
	@Value("${weixin_download_file_url}")
	private String weixinDownloadFileUrl;
	
	@Value("${we_chat_appID}")
	private String weChatAppID;
	
	@Value("${we_chat_appSecret}")
	private String weChatAppSecret;


	@Value("${pm_appid}")
	private String pmAppid;

	@Value("${pm_secret}")
	private String pmSecret;


	@Value("${we_chat_js_api_ticket_url}")
	private String weChatJsApiTicketUrl;

	@Value("${project_url}")
	private String project_url;

	@Value("${o21p_project_url}")
	private String o21p_project_url;

	
	@Value("${picture_url}")
	private String picture_url;

	@Value("${jscode2session}")
	private String jscode2session;

	@Value("${hl_sn_check_url}")
	private String hl_sn_check_url;

	@Value("${gold_to_jewel}")
	private Integer gold_to_jewel;

	public Integer getGold_to_jewel() {
		return gold_to_jewel;
	}

	public void setGold_to_jewel(Integer gold_to_jewel) {
		this.gold_to_jewel = gold_to_jewel;
	}

	public String getHl_sn_check_url() {
		return hl_sn_check_url;
	}

	public void setHl_sn_check_url(String hl_sn_check_url) {
		this.hl_sn_check_url = hl_sn_check_url;
	}
	public String getO21p_project_url() {
		return o21p_project_url;
	}

	public void setO21p_project_url(String o21p_project_url) {
		this.o21p_project_url = o21p_project_url;
	}
	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public String getProject_url() {
		return project_url;
	}

	public void setProject_url(String project_url) {
		this.project_url = project_url;
	}

	public String getUploadFildDir() {
		return uploadFildDir;
	}

	public void setUploadFildDir(String uploadFildDir) {
		this.uploadFildDir = uploadFildDir;
	}

	public String getWeixinDownloadFileUrl() {
		return weixinDownloadFileUrl;
	}

	public void setWeixinDownloadFileUrl(String weixinDownloadFileUrl) {
		this.weixinDownloadFileUrl = weixinDownloadFileUrl;
	}

	public String getWeChatAppID() {
		return weChatAppID;
	}

	public void setWeChatAppID(String weChatAppID) {
		this.weChatAppID = weChatAppID;
	}

	public String getWeChatAppSecret() {
		return weChatAppSecret;
	}

	public void setWeChatAppSecret(String weChatAppSecret) {
		this.weChatAppSecret = weChatAppSecret;
	}

	public String getWeChatJsApiTicketUrl() {
		return weChatJsApiTicketUrl;
	}

	public void setWeChatJsApiTicketUrl(String weChatJsApiTicketUrl) {
		this.weChatJsApiTicketUrl = weChatJsApiTicketUrl;
	}

	public String getJscode2session() {
		return jscode2session;
	}

	public void setJscode2session(String jscode2session) {
		this.jscode2session = jscode2session;
	}

	public String getPmAppid() {
		return pmAppid;
	}

	public void setPmAppid(String pmAppid) {
		this.pmAppid = pmAppid;
	}

	public String getPmSecret() {
		return pmSecret;
	}

	public void setPmSecret(String pmSecret) {
		this.pmSecret = pmSecret;
	}
}
