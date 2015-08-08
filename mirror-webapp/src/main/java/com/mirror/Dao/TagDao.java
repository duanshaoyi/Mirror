package com.mirror.Dao;

import java.util.List;

import com.mirror.entity.tag.*;
import com.mirror.entity.User.User;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.Resource.Work;

public interface TagDao extends BaseDao<Tag, Long>{
    
	//����userid���Ҷ�Ӧtags
	List<Map_TagUser> findtagsbyUser(Long uid);
	
	//����workid���Ҷ�Ӧtags
	List<Map_TagWork> findtagsbyWork(Long wid);
	
	//����tag��id���ҹ�ϵ
	List<Map_TagWork> findWorkstagsbyTagids(List<Long> tagids);
	
	//��ȡ���б�ǩ
	List<Tag> findAllTags();
}
