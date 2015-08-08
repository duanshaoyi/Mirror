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

		//消息内容
		@Column(name = "msg_content")
		private String msgContent;

		//发送信息者uid
		@Column(name="uidFrom") 
		private Long uidFrom;	
		
		//接受信息者uid
		@Column(name="uidTo") 
		private Long uidTo;
		
		//消息类型msgType（0：到用户 1：到后台）
		@Column(name="msgType")
		private Integer msgType;
		
		//消息是否是新消息标志(0:未读，1：已读)
		@Column(name="isNew")
		private Integer isNew = 0;
		
		//发送消息时间
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