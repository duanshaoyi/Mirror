package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.tag.*;
import com.mirror.entity.User.User;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.Resource.Work;

public interface TagDao extends BaseDao<Tag, Long>{
    
	//根据userid查找对应tags
	List<Map_TagUser> findtagsbyUser(Long uid);
	
	//根据workid查找对应tags
	List<Map_TagWork> findtagsbyWork(Long wid);
	
	//根据tag的id查找关系
	List<Map_TagWork> findWorkstagsbyTagids(List<Long> tagids);
	
	//获取所有标签
	List<Tag> findAllTags();
}
