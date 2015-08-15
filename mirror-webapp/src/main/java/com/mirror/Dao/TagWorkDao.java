package com.mirror.Dao;

import com.mirror.entity.Relation.Map_TagWork;

public interface TagWorkDao extends BaseDao<Map_TagWork, Long>{

	public void deleteTagWorkByWorkid(Long wid);
}
