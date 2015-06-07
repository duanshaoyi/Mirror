package com.mirror.service;

import com.mirror.entity.User.User;

public interface AuthService extends BaseService<User, Long>{
	
	//����û�
	public int insertUser(String nickname, String password, String email, long locationID, 
			String locationName, String iconName, String personalDesc);

	//�û���¼
	public int signinUser(String nickname, String password, String email); 
	
	//�þ��޸�����
	public int modifyPassword(String email, String oldPassword, String newPassword);
	
	//�û���������
	public int resetPassword(String email);
	
	//�û��޸ĸ�����Ϣ
	public int modifyPersonalInfo(String email, String newNickName, String personalDesc, String iconName);
}
