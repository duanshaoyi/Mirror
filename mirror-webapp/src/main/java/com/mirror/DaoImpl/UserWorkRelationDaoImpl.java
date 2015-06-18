package com.mirror.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserWorkRelationDao;
import com.mirror.entity.Relation.UserWork;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;


@Repository("userWorkRelationDaoImpl")
@Transactional
public class UserWorkRelationDaoImpl extends BaseDaoImpl<UserWork, Long> implements UserWorkRelationDao {
	
	@SuppressWarnings("unchecked")
	public List<UserWork> findFavoriteWorksbyUid(Long uid){
		List<UserWork> relations=null;
		
	    String jpql="select uw from UserWork uw where uw.uid=:uid";					
		// 创建查询
		relations = entityManager.createQuery(jpql).setParameter("uid", uid)
				.getResultList();

		return relations;
	} 

}
