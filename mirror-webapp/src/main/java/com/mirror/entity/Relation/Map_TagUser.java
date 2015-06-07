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
		private Double weight;
		
		@Column(name="placeHolder1")
		private String placeHolder1;

		@Column(name="placeHolder2")
		private String placeHolder2;

		@Column(name="placeHolder3")
		private String placeHolder3;

		public Long getUid() {
			return uid;
		}

		public void setUid(Long uid) {
			this.uid = uid;
		}

		public Long getTid() {
			return tid;
		}

		public void setTid(Long tid) {
			this.tid = tid;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
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

		public String getPlaceHolder3() {
			return placeHolder3;
		}

		public void setPlaceHolder3(String placeHolder3) {
			this.placeHolder3 = placeHolder3;
		}
	
}