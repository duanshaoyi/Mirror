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

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 928761517255910033L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long ID;
	
//	@Column(name="create_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , insertable = true)
//	public Timestamp createAt;
//	
//	@Column(name="update_at" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" , insertable = true)
//	public Timestamp updateAt;
	
	@Column(name="create_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , insertable = true)
	public Timestamp createAt;
	
	@Column(name="update_at" , columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" , insertable = true)
	public Timestamp updateAt;
	
	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
}
