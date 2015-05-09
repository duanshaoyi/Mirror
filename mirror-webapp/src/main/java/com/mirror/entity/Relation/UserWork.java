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

	//�û�uid
	@Column(name="uid")
	private long uid;	
	
	//��Ʒwid
	@Column(name="wid") 
	private long wid;
	
	//�������ͣ�0������ 1���ղأ�
	@Column(name="actionType")
	private int actionType;

	//������Ϣʱ��
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
