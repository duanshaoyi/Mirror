package com.mirror.controller;

import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

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
	
	 @RequestMapping(value="/test", method = {RequestMethod.GET})
	    public String test(HttpServletRequest request,Model model, @RequestParam(value="langType", defaultValue="zh") String langType){
	        if(!model.containsAttribute("contentModel")){
	            
	            if(langType.equals("zh")){
	                Locale locale = new Locale("zh", "CN"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
	            }
	            else if(langType.equals("en")){
	                Locale locale = new Locale("en", "US"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
	            }
	            else 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
	            
	            //从后台代码获取国际化信息
	            RequestContext requestContext = new RequestContext(request);
	            model.addAttribute("money", requestContext.getMessage("money"));
	            model.addAttribute("date", requestContext.getMessage("date"));

	            
//	            FormatModel formatModel=new FormatModel();
//
//	            formatModel.setMoney(12345.678);
//	            formatModel.setDate(new Date());
	            System.out.println(requestContext.getMessage("money"));
	            System.out.println(requestContext.getMessage("date"));
	            model.addAttribute("contentModel");
	        }
	        return "globaltest";
	    }
	
}
