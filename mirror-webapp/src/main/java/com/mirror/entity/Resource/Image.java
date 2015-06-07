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

	// ͼƬ���·��
	@Column(name = "fileKey")
	private String fileKey;

	// //ͼƬ����
	// @Column(name="filename")
	// private String filename;
	//
	// //ͼƬ�ߴ�
	// //"icon": [ 100, 49 ] // С��ͼ
	// //"thumb": [ 170, 84 ], //Сͼ
	// //"cover": [ 0, 0 ], //���淽ͼ
	// //"image": [ 595, 295 ], //��ͼ
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

	// ͼƬ״̬
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
