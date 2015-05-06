package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;



@Entity(name = "resource_videos")
public class Video extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2011526394395616325L;

	//视频存放路径
	@Column(name = "fileURL")
	private String fileURL;

	//视频名称
	@Column(name="filename") 
	private String filename;

	//视频类型
	@Column(name="fileType")
	private String type; 
	
	//视频大小
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

	//视频状态
	@Column(name="status")
	private int status;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
}
