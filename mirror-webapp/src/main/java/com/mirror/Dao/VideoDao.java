package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.Resource.Video;

public interface VideoDao extends BaseDao<Video, Long>{

	//��������id����Ƶid������Ʒ·��
	public List<Video> findVideoByUidVid(Long uid, Long vid);
}
