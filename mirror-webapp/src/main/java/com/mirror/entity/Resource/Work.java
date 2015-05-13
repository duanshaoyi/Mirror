package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "resource_work")
public class Work extends BaseEntity{
		/**
	 * 
	 */
	private static final long serialVersionUID = -7121573434953462455L;

		//�ϴ��û�uid
		@Column(name="uid")
		private Long uid;	

		

		//��Ʒ����
		@Column(name = "title")
		private String title;

		//��Ʒ����
		@Column(name="description") 
		private String desciption;

		//��Ʒ��ǩ
		@Column(name="tags") 
		private String tags;

		//��ƷͼƬimageid
		@Column(name="imageid") 
		private Long imageid;

		//��ƷͼƬ���·��imageURL
		@Column(name="imageURL") 
		private String imageURL;

		//��Ʒ��Ƶaudioid
		@Column(name="audioid") 
		private Long audioid;

		//��Ʒ��Ƶ���·��audioURL
		@Column(name="audioURL") 
		private String audioURL;

		//��Ʒ��Ƶvideoid
		@Column(name="videoid") 
		private Long videoid;

		//��Ʒ��Ƶ���·��videoURL
		@Column(name="videoURL") 
		private String videoURL;

		//�ϴ�ʱ��
		@Column(name="commentTime",insertable = true)
		private Timestamp uploadTime;

		//��ƷȨ�� public/private/friend
		@Column(name="privacy")
		private String privacy;

		//��Ʒ�ܷ�����
		@Column(name="canReply")
		private boolean canReply;

		//��Ʒ״̬
		@Column(name="status")
		private int status;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		@Column(name="placeHolder3")
		private String placeHolder3;

		public Work(){
			
		}
		
		public Work(Long uid, String title, String desciption, String tags,
				Long imageid, String imageURL, Long audioid, String audioURL,
				Long videoid, String videoURL, Timestamp uploadTime,
				String privacy, boolean canReply, Integer status) {
			super();
			this.uid = uid;
			this.title = title;
			this.desciption = desciption;
			this.tags = tags;
			this.imageid = imageid;
			this.imageURL = imageURL;
			this.audioid = audioid;
			this.audioURL = audioURL;
			this.videoid = videoid;
			this.videoURL = videoURL;
			this.uploadTime = uploadTime;
			this.privacy = privacy;
			this.canReply = canReply;
			this.status = status;
		}

		public Long getUid() {
			return uid;
		}

		public void setUid(Long uid) {
			this.uid = uid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDesciption() {
			return desciption;
		}

		public void setDesciption(String desciption) {
			this.desciption = desciption;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public Long getImageid() {
			return imageid;
		}

		public void setImageid(Long imageid) {
			this.imageid = imageid;
		}

		public String getImageURL() {
			return imageURL;
		}

		public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
		}

		public Long getAudioid() {
			return audioid;
		}

		public void setAudioid(Long audioid) {
			this.audioid = audioid;
		}

		public String getAudioURL() {
			return audioURL;
		}

		public void setAudioURL(String audioURL) {
			this.audioURL = audioURL;
		}

		public Long getVideoid() {
			return videoid;
		}

		public void setVideoid(Long videoid) {
			this.videoid = videoid;
		}

		public String getVideoURL() {
			return videoURL;
		}

		public void setVideoURL(String videoURL) {
			this.videoURL = videoURL;
		}

		public Timestamp getUploadTime() {
			return uploadTime;
		}

		public void setUploadTime(Timestamp uploadTime) {
			this.uploadTime = uploadTime;
		}

		public String getPrivacy() {
			return privacy;
		}

		public void setPrivacy(String privacy) {
			this.privacy = privacy;
		}

		public boolean isCanReply() {
			return canReply;
		}

		public void setCanReply(boolean canReply) {
			this.canReply = canReply;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
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

		public String getPlaceHolder3() {
			return placeHolder3;
		}

		public void setPlaceHolder3(String placeHolder3) {
			this.placeHolder3 = placeHolder3;
		}
}
	
