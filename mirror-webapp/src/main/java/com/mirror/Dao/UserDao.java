package com.mirror.Dao;

import com.mirror.entity.User.User;;


public interface UserDao extends BaseDao<User, Long>{
	public String findUserByEmail(String email);
	
	public String findUserByNickname(String nickname);
}
