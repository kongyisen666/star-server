package com.framework.util;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.star.config.ProjectConfig;
import com.star.service.SpringContextUtils;

@SuppressWarnings("unchecked")
public class FileUtil {
	/**
	 * 保存文件
	 * @param requestUrl
	 * @return
	 * @throws Exception
	 */
	public static String saveFile(String requestUrl) throws Exception {
		ProjectConfig projectConfig = (ProjectConfig) SpringContextUtils.getBeanByClass(ProjectConfig.class);
		// 文件信息初始化
		String fileSavePath = projectConfig.getUploadFildDir();
		FileUtil.createDir(fileSavePath);
		fileSavePath += "/";
		// 文件信息初始化end

		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		InputStream in = conn.getInputStream();
		String ContentDisposition = conn.getHeaderField("Content-disposition");
		String fileFormat = ".jpg";
		try {
			String wxFileName = ContentDisposition.substring(ContentDisposition.indexOf("filename") + 10,
					ContentDisposition.length() - 1);
			fileFormat = wxFileName.substring(wxFileName.indexOf("."));
		} catch (Exception e) {
		}
		String weixinServerFileName = StringUtil.getFileNameBySysDate() + fileFormat;
		fileSavePath += weixinServerFileName;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileSavePath));
		byte[] data = new byte[1024];
		int len = -1;
		while ((len = in.read(data)) != -1) {
			bos.write(data, 0, len);
		}
		bos.close();
		in.close();
		conn.disconnect();
		return weixinServerFileName;
	}
	/**
	 * @name 创建目录
	 * @description 创建目录
	 * @author 赵丰登
	 * @return
	 */
	public static void createDir(String dir) {
		File dest = new File(dir + "/temp.txt");
		if (!dest.exists()) {
			File fileDir = new File(dest.getParent());
			fileDir.mkdirs();
		}
	}


}
