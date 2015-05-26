package com.mirror.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;
import com.mirror.service.AuthService;

@Service("AuthServiceImpl")
public class AuthServiceImpl extends BaseServiceImpl<User,Long> implements AuthService{
	
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int insertUser(String nickname, String password, String email, long locationID, 
			String locationName, String iconName, String personalDesc){
		if(userDao.findUserByNickname(nickname) != null) return 1;
		if(userDao.findUserByEmail(email) != null) return 2;
		
		User userObj = new User();
		userObj.setNickName(nickname);
		userObj.setPassword(password);
		userObj.setEmail(email);
		userObj.setLocationID(locationID);
		userObj.setLocationName(locationName);
		userObj.setIconPath(iconName);
		userObj.setPersonalDesc(personalDesc);
		userDao.persist(userObj);
		return 0;
	}
}
