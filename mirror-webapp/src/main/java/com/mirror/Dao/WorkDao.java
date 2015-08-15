package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

public interface WorkDao  extends BaseDao<Work, Long>{

	public String findUserEmailByWork(String title);
	
	List<Work> findByPage(String jpql, int pageNo, int pageSize);
	
	List<Work> findPageByUser(User author, int pageNo, int pageSize);
		
	List<Work> findByPage(String jpql, int pageNo, int pageSize, Object... params);
	
	List<Work> findByIDs(List<Long> tag_ids,int pageNo, int pageSize);
	
	List<Work> findByExcludeIDs(List<Long> workids,int pageNo, int pageSize);
	
	List<Work> findTopNByExcludeIDs(List<Long> workids,int limitSize);
	
	List<Work> findBySpecifyIndex(List<Long> workids, int startoffset,int pageNo, int pageSize);
	
	int getRecomandStreamSize(List<Long> workids);
	
	List<Work> findAllWorkByUser(Long authorid);
	
	public void deleteWorkByID(Long ID);
}
