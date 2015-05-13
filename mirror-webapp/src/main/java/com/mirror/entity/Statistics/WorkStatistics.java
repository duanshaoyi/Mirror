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

	//总喜欢数
	@Column(name="likedCount")
	private Long likecount;

	//总收藏数
	@Column(name="favoriteCount")
	private Long favoriteCount;
	
	//总点击数	
	@Column(name="hitsCount")
	private Long hitsCount;
	
	//总停留时间	
	@Column(name="timeonworkCount")
	private Long timeonworkCount;
	
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

	public WorkStatistics(Long likecount, Long favoriteCount, Long hitsCount,
			Long timeonworkCount) {
		super();
		this.likecount = likecount;
		this.favoriteCount = favoriteCount;
		this.hitsCount = hitsCount;
		this.timeonworkCount = timeonworkCount;
	}

	public Long getLikecount() {
		return likecount;
	}

	public void setLikecount(Long likecount) {
		this.likecount = likecount;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Long getHitsCount() {
		return hitsCount;
	}

	public void setHitsCount(Long hitsCount) {
		this.hitsCount = hitsCount;
	}

	public Long getTimeonworkCount() {
		return timeonworkCount;
	}

	public void setTimeonworkCount(Long timeonworkCount) {
		this.timeonworkCount = timeonworkCount;
	}
	
	
}
