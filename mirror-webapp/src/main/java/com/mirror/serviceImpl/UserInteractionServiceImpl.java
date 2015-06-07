package com.mirror.serviceImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mirror.Dao.TagUserDao;
import com.mirror.Dao.UserMsgDao;
import com.mirror.Dao.UserUserRelationDao;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.UserUser;
import com.mirror.entity.User.UserMsg;
import com.mirror.service.UserInteractionService;

@Service("userInteractionServiceImpl")
public class UserInteractionServiceImpl implements UserInteractionService{

	@Resource(name="userMsgDaoImpl")
	private UserMsgDao userMsgDao;
	
	@Resource(name="userUserRelationDaoImpl")
	private UserUserRelationDao userUserRelationDao;
	
	@Resource(name="tagUserDaoImpl")
	private TagUserDao tagUserDao;
	
	@Override
	public int insertUserMsg(Long sendUid, Long recieveUid, String msg, Integer msgType){
		
		Date date = new Date();       
		Timestamp commentTime = new Timestamp(date.getTime());
		UserMsg userMsg = new UserMsg();
		userMsg.setUidFrom(sendUid);
		userMsg.setUidTo(recieveUid);
		userMsg.setMsgContent(msg);
		userMsg.setCommentTime(commentTime);
		userMsg.setMsgType(msgType);
		userMsgDao.persist(userMsg);
		return 0;
	}
	
	@Override
	public int flowUser(Long uidFrom, Long uidTo){
		List<UserUser> userUserList = userUserRelationDao.findUserUserByUid(uidFrom, uidTo);
		if(0 == userUserList.size()){
			UserUser uu = new UserUser();
			uu.setUidFrom(uidFrom);
			uu.setUidTo(uidTo);
			uu.setStatus(0);
			userUserRelationDao.persist(uu);
			return 0;
		}
		
		UserUser uu = userUserList.get(0);
		if(0 == uu.getStatus()){
			//已关注，返回
			return 1;
		}
		uu.setStatus(0);
		userUserRelationDao.merge(uu);	
		return 0;
	}
	
	// 用户屏蔽
	public int cancelFlowUser(Long uidFrom, Long uidTo) {
		List<UserUser> userUserList = userUserRelationDao.findUserUserByUid(uidFrom, uidTo);
		if(0 == userUserList.size()){
			UserUser uu = new UserUser();
			uu.setUidFrom(uidFrom);
			uu.setUidTo(uidTo);
			uu.setStatus(1);
			userUserRelationDao.persist(uu);
			return 0;
		}
		
		UserUser uu = userUserList.get(0);
		if(1 == uu.getStatus()){
			//屏蔽
			return 1;
		}
		uu.setStatus(1);
		userUserRelationDao.merge(uu);	
		return 0;
	}
	
	@Override
	public void insertTags(Long uid, String[] tags){
		
		for(int i = 0; i < tags.length; i++){
			Map_TagUser tagUser = new Map_TagUser();
			tagUser.setUid(uid);
			tagUser.setTid(Long.valueOf(tags[i]));
			tagUserDao.persist(tagUser);
		}
	}
}
