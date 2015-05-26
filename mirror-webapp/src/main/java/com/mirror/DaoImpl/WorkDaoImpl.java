package com.mirror.DaoImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.WorkDao;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

@Repository("workDaoImpl")
@Transactional
public class WorkDaoImpl extends BaseDaoImpl<Work, Long> implements WorkDao{

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
