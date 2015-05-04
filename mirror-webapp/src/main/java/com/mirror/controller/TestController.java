package com.mirror.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.entity.User;
import com.mirror.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Resource(name = "testServiceImpl")
	TestService testService;
	
	@RequestMapping("/bye")
	public String bye(){
		
		System.out.println(testService.getUserByID(1));
		return "bye";
	}
}
