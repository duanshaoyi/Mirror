package com.mirror.DaoImpl;

import org.springframework.stereotype.Repository;

import com.mirror.Dao.TagUserDao;
import com.mirror.entity.Relation.Map_TagUser;

@Repository("tagUserDaoImpl")
public class TagUserDaoImpl  extends BaseDaoImpl<Map_TagUser, Long> implements TagUserDao{

}
