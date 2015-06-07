package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Relation.UserUser;

public interface UserUserRelationDao extends BaseDao<UserUser,Long>{
	
	//根据uid获取该用户关注的人列表
	public List<UserUser> findFollowersByUid(Long uid);
	
	//根据uid获取该用户所关注的人列表
	public List<UserUser> findFolloweesByUid(Long uid);
	
	//根据关注和被关注者 id获取记录
	public List<UserUser> findUserUserByUid(Long uidFrom, Long uidTo);
	
	int findstatusByuids(Long uidfrom, Long uidto);

}
