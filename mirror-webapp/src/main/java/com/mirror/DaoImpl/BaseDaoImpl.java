package com.mirror.DaoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.util.Assert;

import com.mirror.Dao.BaseDao;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	private Class<T> entityClass;
	@PersistenceContext
	protected EntityManager entityManager;

	public BaseDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
        entityClass = ((Class<T>) parameterizedType[0]);
    }
	
	@Override
	public T find(ID id) {
		if (id != null) {
			return entityManager.find(entityClass, id);
		}
		return null;
	}

	@Override
	public void persist(T entity) {
		Assert.notNull(entity);
		entityManager.persist(entity);
	}

	@Override
	public T merge(T entity) {
		Assert.notNull(entity);
		return entityManager.merge(entity);
	}

	@Override
	public void remove(T entity) {
		if (entity != null) {
			entityManager.remove(entity);
		}
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
		return (ID) entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
