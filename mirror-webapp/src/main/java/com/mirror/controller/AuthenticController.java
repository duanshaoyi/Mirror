package com.mirror.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticController {
	
	@RequestMapping(value = { "/signup" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int signup(HttpServletRequest request){
		String parameter = request.getQueryString();
		JSONObject object = JSONObject.fromObject(parameter);
		String nickname = object.getString("nickname");
		String password = object.getString("password");
		String email = object.getString("eamil");
		Long locationID = object.getLong("locationID");
		String locationName = object.getString("locationName");
		String iconName = object.getString("iconName");
		String iconPath = "";
		String personalDesc = object.getString("personalDesc");
		return 0;
	}
}
