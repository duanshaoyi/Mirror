package com.mirror.serviceImpl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mirror.Dao.UserDao;
import com.mirror.Dao.WorkDao;
import com.mirror.entity.User.User;
import com.mirror.service.TestService;

@Service("testServiceImpl")
public class TestServiceImpl extends BaseServiceImpl<User, Long> implements TestService{

	@Resource(name="userDaoImpl")
	private UserDao userDao;

	@Resource(name="workDaoImpl")
	private WorkDao workDao;
	
	@Override
	public String getEmailByUserName(String userName){
		//return userDao.find(Long.valueOf(1)).getEmail();
		return userDao.findUserByNickname(userName);
	}

	@Override
	public String getUserEmailByWork(String title){
		return workDao.findUserEmailByWork(title);
	}

	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
