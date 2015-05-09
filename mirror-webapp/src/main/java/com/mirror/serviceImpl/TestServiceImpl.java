package com.mirror.serviceImpl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;
import com.mirror.service.TestService;

@Service("testServiceImpl")
public class TestServiceImpl extends BaseServiceImpl<User, Long> implements TestService{

	@Resource(name="userDaoImpl")
	private UserDao userDao;



	@Override
	public String getUserByID(Long id) {
		// TODO Auto-generated method stub
		return userDao.find(id).getUserName();
	}



	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
