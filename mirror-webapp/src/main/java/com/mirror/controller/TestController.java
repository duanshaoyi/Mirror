package com.mirror.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.mirror.entity.User.User;
import com.mirror.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Resource(name = "testServiceImpl")
	TestService testService;
	
	@Value("${mysql.password}")
	String mysqlPw;
	
	@RequestMapping(value={"/bye"}, method={RequestMethod.POST})
	@ResponseBody
	public JSONObject bye(HttpServletRequest request){
//		RequestBody bb;
//		System.out.println(testService.getUserByID(Long.valueOf(1)));
//		return testService.getUserByID(Long.valueOf(1));
//		String str1 = request.getQueryString();
//		String decodeStr = "";
//		try {
//			decodeStr = java.net.URLDecoder.decode(content, "utf8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		JSONObject b = new JSONObject();
		String uid = request.getParameter("uid");
		System.out.println(uid);
		JSONArray a = new JSONArray();
		a.add((new JSONObject()).element("url", "http://7xisij.com1.z0.glb.clouddn.com/nihao.jpg"));
		a.add((new JSONObject()).element("url", "http://7xisij.com1.z0.glb.clouddn.com/ɽˮ.jpg"));
		a.add((new JSONObject()).element("url", "http://7xisij.com1.z0.glb.clouddn.com/�羰.jpg"));
		b.element("status", 0);
		b.element("data", a);
//		JSONArray b = new JSONArray();
//		b.add((new JSONObject()).element("bbb", "234"));
//		b.add((new JSONObject()).element("ccc", "456"));
//		BufferedReader br;
//		String line = null;
//		StringBuilder sb = new StringBuilder();
//		try {
//			br = new BufferedReader(new InputStreamReader(
//					request.getInputStream()));
//
//			
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//			System.out.println(sb);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String str2 = request.getParameter("User");
//		return "http://7xisij.com1.z0.glb.clouddn.com/nihao.jpg";
//		JSONObject a = JSONObject.fromObject(sb.toString());
//		List<User> userList = testService.getEmailByUserName(str2);
//		return userList.get(0).getEmail();
//		return this.mysqlPw;
		String aa="";
		try {
			aa = java.net.URLEncoder.encode(a.toString(),"utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	
	@RequestMapping(value = { "/getEmail" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public String getEmailByUserName(@RequestParam(value="user") String user, HttpServletRequest request){
		List<User> userList = testService.getEmailByUserName(user);
		return userList.get(0).getEmail();
//		return testService.getUserEmailByWork("eee");
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
