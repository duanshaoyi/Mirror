package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Relation.UserUser;

public interface UserUserRelationDao extends BaseDao<UserUser,Long>{
	
	//����uid��ȡ���û���ע�����б�
	public List<UserUser> findFollowersByUid(Long uid);
	
	//����uid��ȡ���û�����ע�����б�
	public List<UserUser> findFolloweesByUid(Long uid);
	
	//���ݹ�ע�ͱ���ע�� id��ȡ��¼
	public List<UserUser> findUserUserByUid(Long uidFrom, Long uidTo);
	
	int findstatusByuids(Long uidfrom, Long uidto);

}
