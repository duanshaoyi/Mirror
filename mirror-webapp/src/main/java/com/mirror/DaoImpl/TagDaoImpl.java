package com.mirror.DaoImpl;

import java.util.List;

import com.mirror.Dao.TagDao;
import com.mirror.entity.tag.*;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("TagDaoImpl")
@Transactional
public class TagDaoImpl extends BaseDaoImpl<Tag, Long> implements TagDao {

	//获得所属于某个用户的标签关系集合
	@SuppressWarnings("unchecked")
	public List<Map_TagUser> findtagsbyUser(Long uid){
		
		String jpql="select mtu from Map_TagUser mtu where mtu.uid=:uid";
		
		return entityManager.createQuery(jpql).setParameter("uid", uid)
		.getResultList();
	}
	
	//根据标签id集合获取对应的作品id集合
	@SuppressWarnings("unchecked")
	public List<Map_TagWork> findWorkstagsbyTagids(List<Long> tagids) {
		String jpql = "select mtw from Map_TagWork mtw where mtw.tid IN (:tagids)";

		return entityManager.createQuery(jpql).setParameter("tagids", tagids)
				.getResultList();
	}
	
	//获得所属于某个作品的标签关系集合
	@SuppressWarnings("unchecked")
	public List<Map_TagWork> findtagsbyWork(Long wid){
		String jpql="select mtw from Map_TagWork mtw where mtw.wid=:wid";
		
		return entityManager.createQuery(jpql).setParameter("wid", wid)
		.getResultList();
	}
	
}
