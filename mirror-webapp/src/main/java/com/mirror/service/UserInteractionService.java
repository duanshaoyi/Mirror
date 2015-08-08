package com.mirror.service;

import javax.transaction.Transactional;

@Transactional
public interface UserInteractionService {

	//���˽��
	public int insertUserMsg(Long uidFrom, Long uidTo, String msg, Integer msgType);
	
	//�û���ע
	public int flowUser(Long uidFrom, Long uidTo);
	
	//�û�����
	public int cancelFlowUser(Long uidFrom, Long uidTo);
	
	//Ϊ�û����ǩ
	public void insertTags(Long uid, String[] tags);
	
}
