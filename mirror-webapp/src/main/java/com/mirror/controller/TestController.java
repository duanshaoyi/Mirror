package com.mirror.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
	
	@RequestMapping(value = { "/getEmail" }, method = { RequestMethod.POST })
	@ResponseBody
	public String getEmailByUserName(@RequestParam(value="user") String user, HttpServletRequest request){
		return testService.getEmailByUserName(user);
	}
	
	@RequestMapping(value = { "/http" }, method = { RequestMethod.POST })
	@ResponseBody
	public String getHttp(HttpServletRequest request, HttpServletResponse res){
		System.out.println("1234455");
		String str = request.getQueryString();
//		return testService.getEmailByUserName(user);
		JSONObject a = JSONObject.fromObject(str);
		return "";
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
