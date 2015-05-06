package com.mirror.entity.Relation;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;



@Entity(name = "relation_user_work")
public class UserWork  extends BaseEntity{

	private static final long serialVersionUID = 1645625857955422208L;

	//用户uid
	@Column(name="uid")
	private long uid;	
	
	//作品wid
	@Column(name="wid") 
	private long wid;
	
	//动作类型（0：点赞 1：收藏）
	@Column(name="actionType")
	private int actionType;

	//发送消息时间
	@Column(name="actionTime",insertable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp actionTime;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;
	
	public UserWork(){
		
	}

	public UserWork(long uid, long wid, int actionType, Timestamp actionTime) {
		super();
		this.uid = uid;
		this.wid = wid;
		this.actionType = actionType;
		this.actionTime = actionTime;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getWid() {
		return wid;
	}

	public void setWid(long wid) {
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
