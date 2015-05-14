package com.mirror.DaoImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{

	public String getEmailByUserName(String userName){
		String sql = "select Email from user a where a.nickname = :userName";
		return this.entityManager.createNativeQuery(sql).setParameter("userName", userName).getSingleResult().toString();
	}

	@Override
	public String findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select Email from user a where a.email = :email";
		return this.entityManager.createNativeQuery(sql).setParameter("email", email).getSingleResult().toString();
	}

	@Override
	public String findUserByNickname(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select Email from user a where a.nickname = :userName";
		return this.entityManager.createNativeQuery(sql).setParameter("userName", nickname).getSingleResult().toString();
	}
	

}
