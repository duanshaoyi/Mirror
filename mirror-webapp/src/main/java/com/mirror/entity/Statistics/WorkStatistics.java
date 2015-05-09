package com.mirror.entity.Statistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "statistics_work")
public class WorkStatistics extends BaseEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4857271817711165625L;

	//��ϲ����
	@Column(name="likedCount")
	private long likecount;

	//���ղ���
	@Column(name="favoriteCount")
	private long favoriteCount;
	
	//�ܵ����	
	@Column(name="hitsCount")
	private long hitsCount;
	
	//��ͣ��ʱ��	
	@Column(name="timeonworkCount")
	private long timeonworkCount;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	@Column(name="placeHolder3")
	private String placeHolder3;

	public WorkStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkStatistics(long likecount, long favoriteCount, long hitsCount,
			long timeonworkCount) {
		super();
		this.likecount = likecount;
		this.favoriteCount = favoriteCount;
		this.hitsCount = hitsCount;
		this.timeonworkCount = timeonworkCount;
	}

	public long getLikecount() {
		return likecount;
	}

	public void setLikecount(long likecount) {
		this.likecount = likecount;
	}

	public long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public long getHitsCount() {
		return hitsCount;
	}

	public void setHitsCount(long hitsCount) {
		this.hitsCount = hitsCount;
	}

	public long getTimeonworkCount() {
		return timeonworkCount;
	}

	public void setTimeonworkCount(long timeonworkCount) {
		this.timeonworkCount = timeonworkCount;
	}
	
	
}
