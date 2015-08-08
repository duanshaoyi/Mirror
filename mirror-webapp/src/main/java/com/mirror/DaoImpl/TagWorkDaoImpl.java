package com.mirror.DaoImpl;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.TagWorkDao;
import com.mirror.entity.Relation.Map_TagWork;

@Repository("tagWorkDaoImpl")
public class TagWorkDaoImpl extends BaseDaoImpl<Map_TagWork, Long> implements TagWorkDao{

}
