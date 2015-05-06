package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;



@Entity(name = "resource_audios")
public class Audio extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7768019540591898159L;

		//音频存放路径
		@Column(name = "fileURL")
		private String fileURL;

		//音频名称
		@Column(name="filename") 
		private String filename;

		//音频大小
		@Column(name="fileSize")
		private long size; 

		//归属作品wid
		@Column(name="wid") 
		private long workid;

		//上传用户uid
		@Column(name="uid") 
		private long uid;	
		
		//上传时间
		@Column(name="commentTime",insertable = true)
		@Temporal(TemporalType.TIMESTAMP)
		private Timestamp uploadTime;

		//音频状态
		@Column(name="status")
		private int status;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;
		
		public Audio(){
			
		}

		public Audio(String fileURL, String filename, long size, long workid,
				long uid, Timestamp uploadTime, int status) {
			super();
			this.fileURL = fileURL;
			this.filename = filename;
			this.size = size;
			this.workid = workid;
			this.uid = uid;
			this.uploadTime = uploadTime;
			this.status = status;
		}

		public String getFileURL() {
			return fileURL;
		}

		public void setFileURL(String fileURL) {
			this.fileURL = fileURL;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public long getWorkid() {
			return workid;
		}

		public void setWorkid(long workid) {
			this.workid = workid;
		}

		public long getUid() {
			return uid;
		}

		public void setUid(long uid) {
			this.uid = uid;
		}

		public Timestamp getUploadTime() {
			return uploadTime;
		}

		public void setUploadTime(Timestamp uploadTime) {
			this.uploadTime = uploadTime;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
		

}
