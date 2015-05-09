package com.mirror.entity.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_tag_work_map")
public class Map_TagWork extends BaseEntity {
	
	private static final long serialVersionUID = 1645625857955422208L;

	//��Ʒwid
	@Column(name="wid") 
	private long wid;	
	
	//��ǩtid
	@Column(name="tid") 
	private long tid;

	//Ȩ��
	@Column(name="weight") 
	private double weight;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;

	public Map_TagWork(long wid, long tid, double weight) {
		super();
		this.wid = wid;
		this.tid = tid;
		this.weight = weight;
	}

	public long getWid() {
		return wid;
	}

	public void setWid(long wid) {
		this.wid = wid;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
