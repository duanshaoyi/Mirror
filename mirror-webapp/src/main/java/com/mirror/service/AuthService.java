package com.mirror.service;

import net.sf.json.JSONObject;

import com.mirror.entity.User.User;

public interface AuthService extends BaseService<User, Long>{
	
	public int insertUser(String nickname, String password, String email, long locationID, 
			String locationName, String iconName, String personalDesc);

	public User signinUser(String nickname, String password, String email); 
	
	public int modifyPassword(String email, String oldPassword, String newPassword);
	
	public int resetPassword(String email);
	
	public int modifyPersonalInfo(String email, String newNickName, String personalDesc, String iconName);
}
