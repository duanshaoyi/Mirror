package com.mirror.DaoImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserDao;
import com.mirror.entity.User.User;


@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	@Override
	public List<User> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select * from user a where a.email = :email";
		List<User> userList = this.entityManager.createNativeQuery(sql,User.class).setParameter("email", email).getResultList();
		return userList;
	}

	@Override
	public List<User> findUserByNickname(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select * from user a where a.nickname = :nickname";
		List<User> userList = this.entityManager.createNativeQuery(sql,User.class).setParameter("nickname", nickname).getResultList();
		return userList;
	}
	
	public String testFind(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select nickname from user a where a.nickname = :nickname";
		String sql2 = "select nickname, email from user a where a.nickname = :nickname";
		String sql3 = "select * from user a where a.nickname = :nickname";
		String email = "";
		List<String> emilList = this.entityManager.createNativeQuery(sql).setParameter("nickname", nickname).getResultList();
		// System.out.println(this.entityManager.find(User.class,
		// nickname).getEmail());
		// List list =
		// this.entityManager.createNativeQuery(sql2).setParameter("nickname",
		// nickname).getResultList();
		// System.out.println(((Object[])list.get(0))[0]);
		// User tmp = (User)
		// this.entityManager.createNativeQuery(sql3,User.class).setParameter("nickname",
		// nickname).getSingleResult();
		System.out.println(emilList == null ? "null" : emilList.size());
		System.out.println(emilList.size());
		return email;
	}

}
