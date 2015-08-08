package com.mirror.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.UserMsgDao;
import com.mirror.entity.User.UserMsg;

@Repository("userMsgDaoImpl")
public class UserMsgDaoImpl extends BaseDaoImpl<UserMsg, Long> implements UserMsgDao{

	public List<UserMsg> findUserMsgByUserID(String sendUid, String recieveUid){
		return null;
	}
}
