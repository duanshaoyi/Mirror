package com.mirror.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ResponseJSON {

	

	public static JSONObject getResponseJSON(int status, String errorReason, JSONArray data){
		JSONObject object = new JSONObject();
		object.put("status", status);
		object.put("errorReason", errorReason);
		object.put("data", data);
		return object;
	}
	
}
