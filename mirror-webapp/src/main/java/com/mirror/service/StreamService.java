package com.mirror.service;

import net.sf.json.JSONArray;

import com.mirror.entity.Resource.Work;

public interface StreamService {
	int work_upload(Work w, Long authorid);

	public JSONArray get_usertimeline(Long uid, Long authorid, int pageNo);
	
	public JSONArray get_recomandtimeline(Long uid, int pageNo);
	
	//根据作品id获取播放视频地址
	public String findVideoURL(Long id);
}
