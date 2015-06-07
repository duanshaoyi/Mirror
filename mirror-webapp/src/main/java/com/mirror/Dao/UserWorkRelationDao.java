package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Relation.UserWork;

public interface UserWorkRelationDao extends BaseDao<UserWork,Long> {
	
	List<UserWork> findFavoriteWorksbyUid(Long uid);

}
