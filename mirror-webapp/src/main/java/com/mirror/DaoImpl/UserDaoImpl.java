package com.mirror.DaoImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{


	@Override
	public String findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select email from user a where a.email = :email";
		if(this.entityManager.createNativeQuery(sql).setParameter("email", email).getSingleResult() == null){
			System.out.println("dddddddd");
		}
		return ((User)this.entityManager.createNativeQuery(sql).setParameter("email", email).getSingleResult()).getEmail();
	}

	@Override
	public String findUserByNickname(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select nickname from user a where a.nickname = :nickname";
		String sql2 = "select nickname, email from user a where a.nickname = :nickname";
		String sql3 = "select * from user a where a.nickname = :nickname";
		String email =  (String)this.entityManager.createNativeQuery(sql).setParameter("nickname", nickname).getSingleResult();
//		System.out.println(this.entityManager.find(User.class, nickname).getEmail());
		List list = this.entityManager.createNativeQuery(sql2).setParameter("nickname", nickname).getResultList();
		System.out.println(((Object[])list.get(0))[0]);
		User tmp = (User) this.entityManager.createNativeQuery(sql3,User.class).setParameter("nickname", nickname).getSingleResult(); 
		return email;
	}
	

}
