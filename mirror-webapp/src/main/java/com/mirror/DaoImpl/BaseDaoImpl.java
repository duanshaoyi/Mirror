package com.mirror.DaoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.mirror.Dao.BaseDao;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	private Class<T> entityClass;
	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type)
				.getActualTypeArguments();
		entityClass = ((Class<T>) parameterizedType[0]);
	}

	/*--------执行自定义SQL语句方法----------*/
	// 根据JPQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> executeJPQL(String jpql) {
		return (List<T>) entityManager.createQuery(jpql).getResultList();
	}

	// 根据带占位符参数JPQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> executeJPQL(String jpql, Object[] params) {
		// 创建查询
		Query query = entityManager.createQuery(jpql);
		// 为包含占位符的JPQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		return (List<T>) query.getResultList();
	}

	/*------- end------------------------*/

	// 根据ID 获得实体
	@Override
	public T find(ID id) {
		if (id != null) {
			return entityManager.find(entityClass, id);
		}
		return null;
	}

	// 获取所有实体
	@Override
	public List<T> findAll(Class<T> entityClass) {
		return executeJPQL("select en from " + entityClass.getSimpleName()
				+ " en");
	}

	// 插入
	@Override
	public void persist(T entity) {
		Assert.notNull(entity);
		entityManager.persist(entity);
	}

	// 更新
	@Override
	public T merge(T entity) {
		Assert.notNull(entity);
		return entityManager.merge(entity);
	}

	// 删除实体
	@Override
	public void remove(T entity) {
		if (entity != null) {
			entityManager.remove(entity);
		}
	}

	// 根据ID删除实体
	@Override
	public void remove(T entity, ID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(T entity) {
		Assert.notNull(entity);
		entityManager.refresh(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID getIdentifier(T entity) {
		Assert.notNull(entity);
		return (ID) entityManager.getEntityManagerFactory()
				.getPersistenceUnitUtil().getIdentifier(entity);
	}

	// 获取实体总数
	@Override
	public long findCount(Class<T> entityClass) {
		List<?> l = executeJPQL("select count(*) from "
				+ entityClass.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
