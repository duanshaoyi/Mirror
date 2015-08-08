package com.mirror.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserUserRelationDao;
import com.mirror.entity.Relation.UserUser;

@Repository("userUserRelationDaoImpl")
public class UserUserRelationDaoImpl extends BaseDaoImpl<UserUser, Long>
		implements UserUserRelationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserUser> findFollowersByUid(Long uid) {
		// TODO Auto-generated method stub
		List<UserUser> uurl = null;

		String jpql = "select uurl from UserUser uu where uu.uidFrom=:uid";
		// 创建查询
		uurl = entityManager.createQuery(jpql).setParameter("uid", uid)
				.getResultList();

		return uurl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserUser> findFolloweesByUid(Long uid) {
		List<UserUser> uurl = null;

		String jpql = "select uurl from UserUser uu where uu.uidTo=:uid";
		// 创建查询
		uurl = entityManager.createQuery(jpql).setParameter("uid", uid)
				.getResultList();

		return uurl;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserUser> findUserUserByUid(Long uidFrom, Long uidTo){
		String sql = "select * from UserUser uu where uu.uidFrom=:uidFrom and uu.uidTo=:uidTo";
		List<UserUser> uurl = entityManager.createNativeQuery(sql, UserUser.class).setParameter("uidFrom", uidFrom).setParameter("uidTo", uidTo).getResultList();
		return uurl;
	}
	
	@Override
	public int findstatusByuids(Long uidFrom, Long uidTo) {

		int status=0;
		String jpql = "select uu.status from UserUser uu where uu.uidFrom=:uidFrom and uu.uidTo=:uidTo";
		// 创建查询
		status = entityManager.createQuery(jpql)
				.setParameter("uidFrom", uidFrom).setParameter("uidTo", uidTo)
				.getFirstResult();
		
		return status;
	}
}
