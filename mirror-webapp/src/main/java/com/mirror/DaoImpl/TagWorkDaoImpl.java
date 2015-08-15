package com.mirror.DaoImpl;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.TagWorkDao;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.User.User;

@Repository("tagWorkDaoImpl")
public class TagWorkDaoImpl extends BaseDaoImpl<Map_TagWork, Long> implements TagWorkDao{

	public void deleteTagWorkByWorkid(Long wid){
		String sql = "delete from relation_tag_work_map where wid = :wid";
		this.entityManager.createNativeQuery(sql).setParameter("wid", wid).executeUpdate();
	}
}
