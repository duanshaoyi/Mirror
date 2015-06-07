package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;

@Entity
@Table(name = "resource_videos")
public class Video extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2011526394395616325L;

	// ��Ƶ���·��
	@Column(name = "fileKey")
	private String fileKey;
	//
	// //��Ƶ����
	// @Column(name="filename")
	// private String filename;
	//
	// //��Ƶ����
	// @Column(name="fileType")
	// private String type;
	//
	// //��Ƶ��С
	// @Column(name="fileSize")
	// private Long size;

	// ������Ʒwid
	@Column(name = "wid")
	private Long workid;

	// �ϴ��û�uid
	@Column(name = "uid")
	private Long uid;

	// �ϴ�ʱ��
	@Column(name = "commentTime", insertable = true)
	private Timestamp uploadTime;

	// ��Ƶ״̬
	@Column(name = "status")
	private Integer status;

	@Column(name = "placeHolder1")
	private String placeHolder1;

	@Column(name = "placeHolder2")
	private String placeHolder2;

	public Video() {
		super();
	}

	public Video(String fileKey, Long workid, Long uid, Timestamp uploadTime,
			int status) {
		super();
		this.fileKey = fileKey;
		this.workid = workid;
		this.uid = uid;
		this.uploadTime = uploadTime;
		this.status = status;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public Long getWorkid() {
		return workid;
	}

	public void setWorkid(Long workid) {
		this.workid = workid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
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
