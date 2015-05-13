package com.mirror.entity.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_tag_user_map")
public class Map_TagUser extends BaseEntity{
	private static final long serialVersionUID = 1645625857955422208L;

		//用户uid
		@Column(name="uid") 
		private Long uid;	
		
		//标签tid
		@Column(name="tid") 
		private Long tid;

		//权重
		@Column(name="weight") 
		private double weight;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		@Column(name="placeHolder3")
		private String placeHolder3;
	

}