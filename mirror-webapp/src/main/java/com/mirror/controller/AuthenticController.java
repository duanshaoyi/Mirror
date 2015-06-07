package com.mirror.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.service.AuthService;


/**
 * 
 * @author GXM
 * 用户权限相关操作
 */
@RestController
@RequestMapping("/auth")
public class AuthenticController {
	
	@Resource(name="AuthServiceImpl")
	private AuthService authService;
	
	@RequestMapping(value = { "/signup" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int signup(HttpServletRequest request){
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Long locationID = Long.valueOf(request.getParameter("locationID"));
		String locationName = request.getParameter("locationName");
		String iconName = request.getParameter("iconName");
		String personalDesc = request.getParameter("personalDesc");
		return authService.insertUser(nickname, password, email, locationID, 
				locationName, iconName, personalDesc);
	}
	
	@RequestMapping(value = { "/signin" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int signin(HttpServletRequest request){
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		return authService.signinUser(nickname, password, email);
	}
	
	@RequestMapping(value = { "/modifypw" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int modifyPassword(HttpServletRequest request){
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String email = request.getParameter("email");
		return authService.modifyPassword(email, oldPassword, newPassword);
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
	public int modifyInfo(HttpServletRequest request){
		String email = request.getParameter("email");
		String newNickname = request.getParameter("newNickname");
		String personalDesc = request.getParameter("personalDesc");
		String iconName = request.getParameter("iconName");
		this.authService.modifyPersonalInfo(email, newNickname, personalDesc, iconName);
		return 0;
	}
}
