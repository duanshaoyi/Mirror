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
public class Video extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2011526394395616325L;

	//��Ƶ���·��
	@Column(name = "fileURL")
	private String fileURL;

	//��Ƶ����
	@Column(name="filename") 
	private String filename;

	//��Ƶ����
	@Column(name="fileType")
	private String type; 
	
	//��Ƶ��С
	@Column(name="fileSize")
	private Long size; 

	//������Ʒwid
	@Column(name="wid") 
	private Long workid;

	//�ϴ��û�uid
	@Column(name="uid") 
	private Long uid;	
	
	//�ϴ�ʱ��
	@Column(name="commentTime",insertable = true)
	private Timestamp uploadTime;

	//��Ƶ״̬
	@Column(name="status")
	private int status;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
}
