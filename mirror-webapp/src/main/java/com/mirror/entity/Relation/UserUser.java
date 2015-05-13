package com.mirror.entity.Relation;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_user_user")
public class UserUser extends BaseEntity{
	private static final long serialVersionUID = 1645625857955422208L;

	//��ϵ������uid
	@Column(name="uidFrom") 
	private Long uidFrom;	
	
	//��ϵ������uid
	@Column(name="uidTo") 
	private Long uidTo;
	
	//��ϵ״̬��0����ע 1�����Σ�
	@Column(name="status")
	private Integer status;

	public Long getUidFrom() {
		return uidFrom;
	}

	public void setUidFrom(Long uidFrom) {
		this.uidFrom = uidFrom;
	}

	public Long getUidTo() {
		return uidTo;
	}

	public void setUidTo(Long uidTo) {
		this.uidTo = uidTo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
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

	//������Ϣʱ��
	@Column(name="commentTime",insertable = true)
	private Timestamp commentTime;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
}
