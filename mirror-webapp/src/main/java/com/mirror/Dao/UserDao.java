package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.User.User;;


public interface UserDao extends BaseDao<User, Long>{
	
	//������������û�
	public List<User> findUserByEmail(String email);
	
	//�����û��������û�
	public List<User> findUserByNickname(String nickname);
	
}
