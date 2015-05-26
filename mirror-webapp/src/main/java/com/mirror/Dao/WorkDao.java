package com.mirror.Dao;

import com.mirror.entity.Resource.Work;

public interface WorkDao  extends BaseDao<Work, Long>{

	public String findUserEmailByWork(String title);
}
