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
	private Long cid;	
	
	//±Í«©tid
	@Column(name="tid") 
	private Long tid;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;

	public Map_TagCrowd(Long cid, Long tid) {
		super();
		this.cid = cid;
		this.tid = tid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}
	
	

}
