package com.mirror.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.VideoDao;
import com.mirror.entity.Resource.Video;

@Repository("videoDaoImpl")
@Transactional
public class VideoDaoImpl extends BaseDaoImpl<Video, Long> implements VideoDao{

	
	public List<Video> findVideoByUidVid(Long uid, Long vid){
		String sql = "select * from Video v where v.uid=:uid and v.wid=:vid";
		return null;
	}
}
