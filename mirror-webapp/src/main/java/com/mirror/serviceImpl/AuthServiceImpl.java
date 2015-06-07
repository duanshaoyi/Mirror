package com.mirror.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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
			
		if(0 != userDao.findUserByNickname(nickname).size())
			return 1;
		if(0 != userDao.findUserByEmail(email).size())
			return 2;
		
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
	
	public int signinUser(String nickname, String password, String email){
		
		List<User> userList = new ArrayList<User>();
		if(0 != userDao.findUserByNickname(nickname).size()){
			userList = userDao.findUserByNickname(nickname);
		}else if(0 != userDao.findUserByEmail(email).size()){
			userList = userDao.findUserByEmail(email);
		}else{
			return 1;
		}
		
		if(!userList.get(0).getPassword().equals(password))
			return 1;
		
		return 0;
	}
	
	public int modifyPassword(String email, String oldPassword, String newPassword){
		
		List<User> userList = userDao.findUserByEmail(email);
		
		//邮箱输入错误，不存在该邮箱
		if(0 == userList.size())
			return 2;
		
		User user = userList.get(0);
		String password = user.getPassword();
		//旧密码输入错误或新旧密码相同
		if(!password.equals(oldPassword) || oldPassword.equals(newPassword))
			return 1;
		
		user.setPassword(newPassword);
		userDao.merge(user);
		return 0;
	}
	
	public int resetPassword(String email){
			
		return 0;
	}
		
		
	public int modifyPersonalInfo(String email, String newNickname, String personalDesc, String iconName){
		
		List<User> userList = userDao.findUserByEmail(email);
		
		//邮箱输入错误，不存在该用戶
		if(0 == userList.size())
			return 2;
		
		User user = userList.get(0);
		user.setNickName(newNickname);
		user.setPersonalDesc(personalDesc);
		user.setIconPath(iconName);
		userDao.merge(user);
		return 0;
	}	
}
