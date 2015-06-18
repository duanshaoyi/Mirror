package com.mirror.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.service.UserInteractionService;
import com.mirror.util.ResponseJSON;

/**
 * 
 * @author GXM
 * 用户与用户之间交互
 */
@RestController
@RequestMapping("/user")
public class UserInteractionController {

	@Resource(name="userInteractionServiceImpl")
	private UserInteractionService userInteractionService;
	
	@RequestMapping(value = { "/sendmsg" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject sendMsg(HttpServletRequest request){

		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		String msg = request.getParameter("msg");
		Integer msgType = Integer.valueOf(request.getParameter("msgType"));
		int status = userInteractionService.insertUserMsg(uidFrom, uidTo, msg, msgType);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/flow" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject flow(HttpServletRequest request){
		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		int status = userInteractionService.flowUser(uidFrom, uidTo);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/cancelflow" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject cancelflow(HttpServletRequest request){
		Long uidFrom = Long.valueOf(request.getParameter("uidFrom"));
		Long uidTo = Long.valueOf(request.getParameter("uidTo"));
		
		int status = userInteractionService.cancelFlowUser(uidFrom, uidTo);
		return ResponseJSON.getResponseJSON(status, null, null);
	}
	
	@RequestMapping(value = { "/tags" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject tags(HttpServletRequest request){
		Long uid = Long.valueOf(request.getParameter("userID"));
		String[] tags = request.getParameter("tags").split("_");		
		userInteractionService.insertTags(uid, tags);
		return ResponseJSON.getResponseJSON(0, null, null);
	}
}
