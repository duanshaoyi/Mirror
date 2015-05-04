package com.mirror.entity;

import javax.persistence.Column;
import javax.persistence.Entity;



@Entity(name = "user")
public class User  extends BaseEntity{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645625857955422208L;
	
	@Column
	private String userName;
	@Column(name = "backup")
	private String backup;
	

	@Column
	private String userNameGenerate;

	public String getUserNameGenerate() {
		return userNameGenerate;
	}

	public void setUserNameGenerate(String userNameGenerate) {
		this.userNameGenerate = userNameGenerate;
	}

	
	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	
}
