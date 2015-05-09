package com.mirror.entity.User;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "user_msg")
public class UserMsg  extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7384921324309070942L;

		//消息内容
		@Column(name = "content")
		private String msgContent;

		//发送信息者uid
		@Column(name="uidFrom") 
		private long uidFrom;	
		
		//接受信息者uid
		@Column(name="uidTo") 
		private long uidTo;
		
		//消息类型msgType（0：到用户 1：到后台）
		@Column(name="msgType")
		private int msgType;

		//发送消息时间
		@Column(name="commentTime",insertable = true)
		private Timestamp commentTime;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

	
}