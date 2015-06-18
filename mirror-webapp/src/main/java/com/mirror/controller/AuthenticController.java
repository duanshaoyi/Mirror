package com.mirror.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.service.AuthService;
import com.mirror.util.ResponseJSON;


/**
 * 
 * @author GXM
 * 用户鉴权模块，控制登录，修改信息等
 */
@RestController
@RequestMapping("/auth")
public class AuthenticController {
	
	@Resource(name="AuthServiceImpl")
	private AuthService authService;
	
	@RequestMapping(value = { "/signup" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject signup(HttpServletRequest request){
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Long locationID = Long.valueOf(request.getParameter("locationID"));
		String locationName = request.getParameter("locationName");
		String iconName = request.getParameter("iconName");
		String personalDesc = request.getParameter("personalDesc");
		int status = authService.insertUser(nickname, password, email, locationID, 
				locationName, iconName, personalDesc);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/signin" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject signin(HttpServletRequest request){
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int status = authService.signinUser(nickname, password, email);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/modifypw" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject modifyPassword(HttpServletRequest request){
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String email = request.getParameter("email");
		int status = authService.modifyPassword(email, oldPassword, newPassword);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/forgetpw" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int forgetPassword(HttpServletRequest request){
		String parameter = request.getQueryString();
		JSONObject object = JSONObject.fromObject(parameter);
		
		return 0;
	}
	
	@RequestMapping(value = { "/modifyInfo" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject modifyInfo(HttpServletRequest request){
		String email = request.getParameter("email");
		String newNickname = request.getParameter("newNickname");
		String personalDesc = request.getParameter("personalDesc");
		String iconName = request.getParameter("iconName");
		int status = authService.modifyPersonalInfo(email, newNickname, personalDesc, iconName);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	public static void main(String[] args) {
		JSONObject a = new JSONObject();
		a.put("status", 0);
		a.put("errorReason", null);
		a.put("data", null);
		System.out.println(ResponseJSON.getResponseJSON(1, null, null));
		Date d = new Date();
		System.out.println(d.getTime());
		Timestamp aa = new Timestamp(new Date().getTime());
		System.out.println(aa);
	}
}
