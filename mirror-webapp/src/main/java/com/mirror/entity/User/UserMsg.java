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

		//��Ϣ����
		@Column(name = "content")
		private String msgContent;

		//������Ϣ��uid
		@Column(name="uidFrom") 
		private long uidFrom;	
		
		//������Ϣ��uid
		@Column(name="uidTo") 
		private long uidTo;
		
		//��Ϣ����msgType��0�����û� 1������̨��
		@Column(name="msgType")
		private int msgType;

		//������Ϣʱ��
		@Column(name="commentTime",insertable = true)
		private Timestamp commentTime;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

	
}