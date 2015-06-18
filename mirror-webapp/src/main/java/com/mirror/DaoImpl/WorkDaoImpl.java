package com.mirror.DaoImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.WorkDao;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

@Repository("workDaoImpl")
@Transactional
public class WorkDaoImpl extends BaseDaoImpl<Work, Long> implements WorkDao{

	/**
	 * seach based on jpql
	 * @param jpql
	 * @param pageNo 
	 * @param pageSize
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize) {
		return entityManager.createQuery(jpql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
	}
	
	/**
	 * find List<Work> based author id
	 * @param author
	 * @param pageNo 
	 * @param pageSize 
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findPageByUser(User author, int pageNo, int pageSize) {
		String jpql="select w from Work w where w.user=:author";
		
		return entityManager.createQuery(jpql).setParameter("author", author)
	    //.setParameter("uid", uid)
//		.setFirstResult((pageNo - 1) * pageSize)
		.setFirstResult(0)
		.setMaxResults(pageSize)
		.getResultList();
	}


	/**
	 * @param jpql    
	 * @param params 	            
	 * @param pageNo 	        
	 * @param pageSize 	        
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize,
			Object... params) {
		Query query = entityManager.createQuery(jpql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
	}
	
	@Override
	public String findUserEmailByWork(String title) {
		String sql = "select * from resource_work a where a.title = :title";
//		if(this.entityManager.createNativeQuery(sql).setParameter("title", title).getSingleResult() == null){
//			System.out.println("dddddddd");
//		}
//		Work work = (Work)this.entityManager.createNativeQuery(sql,Work.class).setParameter("title", title).getSingleResult();
		Work work = (Work)this.entityManager.createNativeQuery(sql,Work.class).setParameter("title", title).getSingleResult();

		String email = work.getUser().getEmail();
		return email;
//		String email = this.find(Long.valueOf(1)).getUser().getEmail();
//		return email;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findByIDs(List<Long> ids,int pageNo, int pageSize){
		String jpql="select w from Work w where ID IN(:ids)";
		
		return entityManager.createQuery(jpql).setParameter("ids", ids)
	    //.setParameter("uid", uid)
//		.setFirstResult((pageNo - 1) * pageSize)
//		.setFirstResult(0)
//		.setMaxResults(pageSize)
		.getResultList();
		
	}
}
