package com.mirror.DaoImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.WorkDao;
import com.mirror.entity.Resource.Video;
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
		.setFirstResult((pageNo - 1) * pageSize)
//		.setFirstResult(0)
		.setMaxResults(pageSize)
		.getResultList();
	}
	
	//
	@SuppressWarnings("unchecked")
	public List<Work> findAllWorkByUser(Long authorid) {
		String sql="select * from resource_work w where w.uid=:authorid order by w.create_at desc";
		return entityManager.createNativeQuery(sql, Work.class).setParameter("authorid", authorid).getResultList();
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
	public List<Work> findByIDs(List<Long> workids,int pageNo, int pageSize){
		String jpql="select w from Work w where ID IN (:workids)";
		
		return entityManager.createQuery(jpql).setParameter("workids", workids)
	    //.setParameter("uid", uid)
		.setFirstResult((pageNo - 1) * pageSize)
//		.setFirstResult(0)
		.setMaxResults(pageSize)
		.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findByExcludeIDs(List<Long> workids,int pageNo, int pageSize){
		String jpql="select w from Work w where ID NOT IN (:workids)";
		
		return entityManager.createQuery(jpql).setParameter("workids", workids)
	    //.setParameter("uid", uid)
		.setFirstResult((pageNo - 1) * pageSize)
//		.setFirstResult(0)
		.setMaxResults(pageSize)
		.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findTopNByExcludeIDs(List<Long> workids,int limitSize){
		String jpql="select w from Work w where ID NOT IN (:workids)";
		
		return entityManager.createQuery(jpql).setParameter("workids", workids)
		.setMaxResults(limitSize)
		.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findBySpecifyIndex(List<Long> workids, int offset,int pageNo, int pageSize){
		String jpql="select w from Work w where ID NOT IN (:workids)";
		
		//int offset=startoffset+1;
		
		return entityManager.createQuery(jpql).setParameter("workids", workids)
	    //.setParameter("uid", uid)
		.setFirstResult(((pageNo - 1) * pageSize)+offset)
//		.setFirstResult(0)
		.setMaxResults(pageSize)
		.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getRecomandStreamSize(List<Long> workids){
		String jpql="select w from Work w where ID IN (:workids)";
		
		int size=0;		
		size = entityManager.createQuery(jpql).setParameter("workids", workids).getResultList().size();
	 
		return size;
	}
	
	public void deleteWorkByID(Long ID){
		String sql = "delete from resource_work where ID=:ID";
		this.entityManager.createNativeQuery(sql, Video.class).setParameter("ID", ID).executeUpdate();
	}
}
