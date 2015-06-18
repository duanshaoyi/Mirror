package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.tag.*;
import com.mirror.entity.User.User;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.Resource.Work;

public interface TagDao extends BaseDao<Tag, Long>{
    
	//获得所属于某个用户的标签关系集合
	List<Map_TagUser> findtagsbyUser(Long uid);
	
	//获得所属于某个作品的标签关系集合
	List<Map_TagWork> findtagsbyWork(Long wid);
	
	//根据标签id集合获取对应的作品id集合
	List<Map_TagWork> findWorkstagsbyTagids(List<Long> tagids);
	
}
