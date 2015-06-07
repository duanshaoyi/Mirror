package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.User.User;;


public interface UserDao extends BaseDao<User, Long>{
	
	//根据邮箱查找用户
	public List<User> findUserByEmail(String email);
	
	//根据用户名查找用户
	public List<User> findUserByNickname(String nickname);
	
}
