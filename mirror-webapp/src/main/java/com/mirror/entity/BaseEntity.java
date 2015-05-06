package com.mirror.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 928761517255910033L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@Column(name="createAt",insertable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp createAt;
	
	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	@Column(name="updateAt",insertable = true)
	public Timestamp updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
}
