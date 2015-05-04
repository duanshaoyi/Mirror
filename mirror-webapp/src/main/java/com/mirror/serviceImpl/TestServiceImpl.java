package com.mirror.serviceImpl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mirror.Dao.UserDao;
import com.mirror.service.TestService;

@Service("testServiceImpl")
public class TestServiceImpl implements TestService{

	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUserByID(int id){
		
		return userDao.getUserNameByID(id);
	} 
}
