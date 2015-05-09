package com.mirror.entity.tag;


import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "tags")
public class Tag extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645625857955422208L;
	
	//��ǩ����
	@Column(name = "content")
	private String content;

	//��ǩ���
	@Column(name="catogory") 
	private String catogory;	
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;
	
	public Tag(){
		
	}

	public Tag(String content, String catogory) {
		super();
		this.content = content;
		this.catogory = catogory;
	}

	
}