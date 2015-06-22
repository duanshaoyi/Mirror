package com.mirror.util;

import com.qiniu.util.Auth;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtil {

	// 七牛域名
	private static final String domain = "http://7xisij.com1.z0.glb.clouddn.com/";
		
	private static final String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
	private static final String SECRET_KEY = "igdpaFrIWjkmBAfUGlxLMEfJLSGwLPe4Jj_LDmMR";

	public static JSONObject getResponseJSON(int status, String errorReason, JSONArray data){
		JSONObject object = new JSONObject();
		object.put("status", status);
		object.put("errorReason", errorReason);
		object.put("data", data);
		return object;
	}
	
	//generate qiniu download work url 
	public static String findDownloadURL(String fileKey) {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String url = domain + fileKey;
		String urlSigned = auth.privateDownloadUrl(url);
		return urlSigned;
	}
}
