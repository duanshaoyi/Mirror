package com.mirror.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Resource(name = "testServiceImpl")
	TestService testService;
	
	@RequestMapping("/bye")
	public String bye(){
		
//		System.out.println(testService.getUserByID(Long.valueOf(1)));
//		return testService.getUserByID(Long.valueOf(1));
		return "bye";
	}
	
	@RequestMapping(value = { "/getEmail" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public String getEmailByUserName(@RequestParam(value="user") String user){
		
		return testService.getEmailByUserName(user);
	}
	
}
