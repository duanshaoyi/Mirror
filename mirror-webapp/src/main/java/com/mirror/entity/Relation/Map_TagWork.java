package com.mirror.entity.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_tag_work_map")
public class Map_TagWork extends BaseEntity {
	
	private static final long serialVersionUID = 1645625857955422208L;

	@Column(name="wid") 
	private Long wid;	
	
	@Column(name="tid") 
	private Long tid;

	@Column(name="weight",length=20) 
	private Double weight;
	
	public Map_TagWork(){}
	
	public Map_TagWork(Long wid, Long tid, double weight) {
		super();
		this.wid = wid;
		this.tid = tid;
		this.weight = weight;
	}

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
