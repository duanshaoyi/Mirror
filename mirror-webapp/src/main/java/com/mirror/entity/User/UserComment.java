package com.mirror.entity.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "user_comment")
public class UserComment  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		//��������
		@Column(name = "content")
		private String userName;

		//����������uid
		@Column(name="uid")
		private long publisherId;
		
		//���۹�����Ʒwid
		@Column(name="wid")
		private long workID;

		//����ʱ��
		@Column(name="commentTime",insertable = true)
		@Temporal(TemporalType.TIMESTAMP)
		private Date commentTime;

		//����״̬����ɾ��0���Ѽ���1��
		@Column(name="status")
		private int status;
		
		//������IP
		@Column(name="ip")
		private String ip;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public long getPublisherId() {
			return publisherId;
		}

		public void setPublisherId(long publisherId) {
			this.publisherId = publisherId;
		}

		public long getWorkID() {
			return workID;
		}

		public void setWorkID(long workID) {
			this.workID = workID;
		}

		public Date getCommentTime() {
			return commentTime;
		}

		public void setCommentTime(Date commentTime) {
			this.commentTime = commentTime;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

	
	
}