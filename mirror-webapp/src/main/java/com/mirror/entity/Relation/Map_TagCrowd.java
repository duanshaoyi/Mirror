package com.mirror.entity.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "relation_tag_crowd_map")
public class Map_TagCrowd extends BaseEntity{
	private static final long serialVersionUID = 1645625857955422208L;

	//»À»∫cid
	@Column(name="cid") 
	private int cid;	
	
	//±Í«©tid
	@Column(name="tid") 
	private long tid;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;

	public Map_TagCrowd(int cid, long tid) {
		super();
		this.cid = cid;
		this.tid = tid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}
	
	

}
