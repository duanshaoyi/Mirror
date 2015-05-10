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
	
		//评论内容
		@Column(name = "comment_content")
		private String commentContent;

		//发布评论者uid
		@Column(name="publisher_ID")
		private long publisherID;
		
		//评论关联作品wid
		@Column(name="wid")
		private long workID;

		//评论时间
		@Column(name="commentTime",insertable = true)
		@Temporal(TemporalType.TIMESTAMP)
		private Date commentTime;

		//评论状态（已删除0，已激活1）
		@Column(name="status")
		private int status;
		
		//评论者IP
		@Column(name="ip")
		private String ip;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		public String getCommentContent() {
			return commentContent;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}

		public long getPublisherID() {
			return publisherID;
		}

		public void setPublisherID(long publisherID) {
			this.publisherID = publisherID;
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