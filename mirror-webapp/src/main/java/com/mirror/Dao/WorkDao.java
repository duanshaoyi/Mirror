package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

public interface WorkDao  extends BaseDao<Work, Long>{

	public String findUserEmailByWork(String title);
	
	List<Work> findByPage(String jpql, int pageNo, int pageSize);
	
	List<Work> findPageByUser(User user, int pageNo, int pageSize);
	
	
	List<Work> findByPage(String jpql, int pageNo, int pageSize, Object... params);
}
