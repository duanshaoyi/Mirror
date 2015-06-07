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
	 * ʹ��JPQL�����з�ҳ��ѯ���� 
	 * @param jpql ��Ҫ��ѯ��JPQL���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize) {
		// ������ѯ
		return entityManager.createQuery(jpql)
				// ִ�з�ҳ
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
	}
	
	/**
	 * ����uid��ø��û���������Ʒ���Է�ҳ��ʽ����
	 * @param author
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findPageByUser(User author, int pageNo, int pageSize) {
		String jpql="select w from Work w where w.user=:author";
		
		
		// ������ѯ
		return entityManager.createQuery(jpql).setParameter("author", author)
	    //.setParameter("uid", uid)
		.setFirstResult((pageNo - 1) * pageSize)// ִ�з�ҳ
		.setMaxResults(pageSize)
		.getResultList();
	}


	/**
	 * ʹ��JPQL�����з�ҳ��ѯ����
	 * @param jpql ��Ҫ��ѯ��JPQL���	   
	 * @param params ���jpql��ռλ��������params���ڴ���ռλ������	            
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼	        
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��	        
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List<Work> findByPage(String jpql, int pageNo, int pageSize,
			Object... params) {
		// ������ѯ
		Query query = entityManager.createQuery(jpql);
		// Ϊ����ռλ����JPQL������ò���
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		// ִ�з�ҳ�������ز�ѯ���
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
