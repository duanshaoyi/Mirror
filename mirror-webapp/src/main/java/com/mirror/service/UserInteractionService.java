package com.mirror.service;

import javax.transaction.Transactional;

@Transactional
public interface UserInteractionService {

	//添加私信
	public int insertUserMsg(Long uidFrom, Long uidTo, String msg, Integer msgType);
	
	//用户关注
	public int flowUser(Long uidFrom, Long uidTo);
	
	//用户屏蔽
	public int cancelFlowUser(Long uidFrom, Long uidTo);
	
	//为用户打标签
	public void insertTags(Long uid, String[] tags);
	
}
