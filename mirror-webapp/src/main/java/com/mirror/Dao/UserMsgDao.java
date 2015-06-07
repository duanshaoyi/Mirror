package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.User.UserMsg;

public interface UserMsgDao extends BaseDao<UserMsg, Long>{
	
	public List<UserMsg> findUserMsgByUserID(String sendUid, String recieveUid);
}
