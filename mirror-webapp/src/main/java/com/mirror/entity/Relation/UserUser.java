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
	private long uidFrom;	
	
	//��ϵ������uid
	@Column(name="uidTo") 
	private long uidTo;
	
	//��ϵ״̬��0����ע 1�����Σ�
	@Column(name="status")
	private int status;

	//������Ϣʱ��
	@Column(name="commentTime",insertable = true)
	private Timestamp commentTime;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
}
