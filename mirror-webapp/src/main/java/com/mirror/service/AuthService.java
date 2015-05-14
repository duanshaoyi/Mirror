package com.mirror.service;

import com.mirror.entity.User.User;

public interface AuthService extends BaseService<User, Long>{
	
	public int insertUser(String nickname, String password, String email, long locationID, 
			String locationName, String iconName, String personalDesc);

}
