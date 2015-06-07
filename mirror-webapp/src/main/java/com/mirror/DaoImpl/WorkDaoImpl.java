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
	 * 使用JPQL语句进行分页查询操作 
	 * @param jpql 需要查询的JPQL语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize) {
		// 创建查询
		return entityManager.createQuery(jpql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
	}
	
	/**
	 * 根据uid获得该用户发布的作品并以分页形式返回
	 * @param author
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findPageByUser(User author, int pageNo, int pageSize) {
		String jpql="select w from Work w where w.user=:author";
		
		
		// 创建查询
		return entityManager.createQuery(jpql).setParameter("author", author)
	    //.setParameter("uid", uid)
		.setFirstResult((pageNo - 1) * pageSize)// 执行分页
		.setMaxResults(pageSize)
		.getResultList();
	}


	/**
	 * 使用JPQL语句进行分页查询操作
	 * @param jpql 需要查询的JPQL语句	   
	 * @param params 如果jpql带占位符参数，params用于传入占位符参数	            
	 * @param pageNo 查询第pageNo页的记录	        
	 * @param pageSize 每页需要显示的记录数	        
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize,
			Object... params) {
		// 创建查询
		Query query = entityManager.createQuery(jpql);
		// 为包含占位符的JPQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		// 执行分页，并返回查询结果
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

}
