package com.mirror.service;

import com.mirror.entity.Resource.Work;

public interface StreamService {
	String work_upload(Work w, Long authorid);

	String get_usertimeline(Long uid, Long authorid, int pageNo);
	
	//������Ʒid��ȡ������Ƶ��ַ
	public String findVideoURL(Long id);
}
