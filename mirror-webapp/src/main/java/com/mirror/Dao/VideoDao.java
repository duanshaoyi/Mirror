package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Resource.Video;

public interface VideoDao extends BaseDao<Video, Long>{

	//根据作者id和视频id查找作品路径
	public List<Video> findVideoByUidVid(Long uid, Long vid);
}
