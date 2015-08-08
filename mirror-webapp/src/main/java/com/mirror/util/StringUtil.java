package com.mirror.util;

import com.qiniu.util.Auth;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtil {

	public static final String domain = "http://7xisij.com1.z0.glb.clouddn.com/";
		
	private static final String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
	private static final String SECRET_KEY = "igdpaFrIWjkmBAfUGlxLMEfJLSGwLPe4Jj_LDmMR";
	private static final long expired = 31536000;
	private static final String frame = "vframe/png/offset/1/w/100/h/100";

	public static JSONObject getResponseJSON(int status, String errorReason, JSONArray data){
		JSONObject object = new JSONObject();
		object.put("status", status);
		object.put("errorReason", errorReason);
		object.put("data", data);
		return object;
	}
	
	//data is JSONObject
	public static JSONObject getResponseJSONObject(int status, String errorReason, JSONObject data){
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
		String urlSigned = auth.privateDownloadUrl(url,expired);
		return urlSigned;
	}
	
	//generate qiniu download work url 
	public static String findWorkFrameDownloadURL(String fileKey) {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String url = domain + fileKey+"?"+frame;
		String urlSigned = auth.privateDownloadUrl(url,expired);
		return urlSigned;
	}
	
}
