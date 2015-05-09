package com.mirror.DaoImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{

//	public String getUserNameByID(Long id){
//		return entityManager.find(User.class, id).getUserName();
//	}
	

}
