package com.mirror.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.service.UserInteractionService;

/**
 * 
 * @author GXM
 * 用户与用户之间交互相关操作
 */
@RestController
@RequestMapping("/user")
public class UserInteractionController {

	@Resource(name="userInteractionServiceImpl")
	private UserInteractionService userInteractionService;
	
	@RequestMapping(value = { "/sendmsg" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int sendMsg(HttpServletRequest request){

		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		String msg = request.getParameter("msg");
		Integer msgType = Integer.valueOf(request.getParameter("msgType"));
		userInteractionService.insertUserMsg(uidFrom, uidTo, msg, msgType);
		return 0;
	}
	
	@RequestMapping(value = { "/flow" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int flow(HttpServletRequest request){
		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		return userInteractionService.flowUser(uidFrom, uidTo);
	}
	
	@RequestMapping(value = { "/cancelflow" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int cancelflow(HttpServletRequest request){
		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		
		return userInteractionService.cancelFlowUser(uidFrom, uidTo);
	}
	
	@RequestMapping(value = { "/tags" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int tags(HttpServletRequest request){
		Long uid = Long.valueOf(request.getParameter("userID"));
		String[] tags = request.getParameter("tags").split("_");		
		userInteractionService.insertTags(uid, tags);
		return 0;
	}
}
