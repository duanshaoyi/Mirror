package com.mirror.entity.Relation;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_user_work")
public class UserWork  extends BaseEntity{

	private static final long serialVersionUID = 1645625857955422208L;

	//用户uid
	@Column(name="uid")
	private Long uid;	
	
	//作品wid
	@Column(name="wid") 
	private Long wid;
	
	//动作类型（0：点赞 1：收藏）
	@Column(name="actionType")
	private int actionType;

	//发送消息时间
	@Column(name="actionTime",insertable = true)
	private Timestamp actionTime;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;
	
	public UserWork(){
		
	}

	public UserWork(Long uid, Long wid, int actionType, Timestamp actionTime) {
		super();
		this.uid = uid;
		this.wid = wid;
		this.actionType = actionType;
		this.actionTime = actionTime;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}
	
	
}
