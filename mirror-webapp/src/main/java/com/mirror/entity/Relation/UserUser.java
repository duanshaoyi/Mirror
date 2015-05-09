package com.mirror.entity.Relation;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_user_user")
public class UserUser extends BaseEntity{
	private static final long serialVersionUID = 1645625857955422208L;

	//关系发起者uid
	@Column(name="uidFrom") 
	private long uidFrom;	
	
	//关系接受者uid
	@Column(name="uidTo") 
	private long uidTo;
	
	//关系状态（0：关注 1：屏蔽）
	@Column(name="status")
	private int status;

	//发送消息时间
	@Column(name="commentTime",insertable = true)
	private Timestamp commentTime;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
}
