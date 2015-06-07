package com.mirror.service;

import com.mirror.entity.User.User;

public interface AuthService extends BaseService<User, Long>{
	
	//添加用户
	public int insertUser(String nickname, String password, String email, long locationID, 
			String locationName, String iconName, String personalDesc);

	//用户登录
	public int signinUser(String nickname, String password, String email); 
	
	//用具修改密码
	public int modifyPassword(String email, String oldPassword, String newPassword);
	
	//用户重置密码
	public int resetPassword(String email);
	
	//用户修改个人信息
	public int modifyPersonalInfo(String email, String newNickName, String personalDesc, String iconName);
}
