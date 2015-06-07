package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;

@Entity
@Table(name = "resource_images")
public class Image extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5147219810472851713L;

	// 图片存放路径
	@Column(name = "fileKey")
	private String fileKey;

	// //图片名称
	// @Column(name="filename")
	// private String filename;
	//
	// //图片尺寸
	// //"icon": [ 100, 49 ] // 小方图
	// //"thumb": [ 170, 84 ], //小图
	// //"cover": [ 0, 0 ], //封面方图
	// //"image": [ 595, 295 ], //大图
	// @Column(name="fileSize")
	// private Long size;

	// 归属作品wid
	@Column(name = "wid")
	private Long workid;

	// 上传用户uid
	@Column(name = "uid")
	private Long uid;

	// 上传时间
	@Column(name = "commentTime", insertable = true)
	private Timestamp uploadTime;

	// 图片状态
	@Column(name = "status")
	private int status;

	@Column(name = "placeHolder1")
	private String placeHolder1;

	@Column(name = "placeHolder2")
	private String placeHolder2;

	public Image() {

	}
	

	public Image(String fileKey, Long workid, Long uid, Timestamp uploadTime,
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
