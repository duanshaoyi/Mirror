package com.mirror.service;

import javax.transaction.Transactional;

import net.sf.json.JSONArray;

import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

@Transactional
public interface StreamService {
	int work_upload(Work w, Long authorid);

	public JSONArray get_usertimeline(Long uid, Long authorid, int pageNo);
	
	public JSONArray get_recomandtimeline(Long uid, int pageNo);
	
	public JSONArray getAllTagsService();
	
	public void updateCurrentWorkPlayCount(Long currentWorkid, Integer playCount);
	
	public String getNextWorkPlayCount(Long nextWorkid);
	
	public JSONArray getAllWorksByAuthor(Long uid , Long authorid);
	
	public void insertTags(Long wid, String[] tags);
}
