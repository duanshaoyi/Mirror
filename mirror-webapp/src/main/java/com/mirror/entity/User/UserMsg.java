package com.mirror.entity.User;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "user_msg")
public class UserMsg  extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7384921324309070942L;

		//��Ϣ����
		@Column(name = "msg_content")
		private String msgContent;

		//������Ϣ��uid
		@Column(name="uidFrom") 
		private Long uidFrom;	
		
		//������Ϣ��uid
		@Column(name="uidTo") 
		private Long uidTo;
		
		//��Ϣ����msgType��0�����û� 1������̨��
		@Column(name="msgType")
		private Integer msgType;
		
		//��Ϣ�Ƿ�������Ϣ��־(0:δ����1���Ѷ�)
		@Column(name="isNew")
		private Integer isNew = 0;
		
		//������Ϣʱ��
		@Column(name="commentTime",insertable = true)
		private Timestamp commentTime;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		public String getMsgContent() {
			return msgContent;
		}

		public void setMsgContent(String msgContent) {
			this.msgContent = msgContent;
		}

		public Long getUidFrom() {
			return uidFrom;
		}

		public void setUidFrom(Long uidFrom) {
			this.uidFrom = uidFrom;
		}

		public Long getUidTo() {
			return uidTo;
		}

		public void setUidTo(Long uidTo) {
			this.uidTo = uidTo;
		}

		public Integer getMsgType() {
			return msgType;
		}

		public void setMsgType(Integer msgType) {
			this.msgType = msgType;
		}

		public Timestamp getCommentTime() {
			return commentTime;
		}

		public void setCommentTime(Timestamp commentTime) {
			this.commentTime = commentTime;
		}

		public String getPlaceHolder1() {
			return placeHolder1;
		}

		public void setPlaceHolder1(String placeHolder1) {
			this.placeHolder1 = placeHolder1;
		}

		public String getPlaceHolder2() {
			return placeHolder2;
		}

		public void setPlaceHolder2(String placeHolder2) {
			this.placeHolder2 = placeHolder2;
		}

		
	
}