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

	/*--------ִ���Զ���SQL��䷽��----------*/
	// ����JPQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> executeJPQL(String jpql) {
		return (List<T>) entityManager.createQuery(jpql).getResultList();
	}

	// ���ݴ�ռλ������JPQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> executeJPQL(String jpql, Object[] params) {
		// ������ѯ
		Query query = entityManager.createQuery(jpql);
		// Ϊ����ռλ����JPQL������ò���
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		return (List<T>) query.getResultList();
	}

	/*------- end------------------------*/

	// ����ID ���ʵ��
	@Override
	public T find(ID id) {
		if (id != null) {
			return entityManager.find(entityClass, id);
		}
		return null;
	}

	// ��ȡ����ʵ��
	@Override
	public List<T> findAll(Class<T> entityClass) {
		return executeJPQL("select en from " + entityClass.getSimpleName()
				+ " en");
	}

	// ����
	@Override
	public void persist(T entity) {
		Assert.notNull(entity);
		entityManager.persist(entity);
	}

	// ����
	@Override
	public T merge(T entity) {
		Assert.notNull(entity);
		return entityManager.merge(entity);
	}

	// ɾ��ʵ��
	@Override
	public void remove(T entity) {
		if (entity != null) {
			entityManager.remove(entity);
		}
	}

	// ����IDɾ��ʵ��
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

	// ��ȡʵ������
	@Override
	public long findCount(Class<T> entityClass) {
		List<?> l = executeJPQL("select count(*) from "
				+ entityClass.getSimpleName());
		// ���ز�ѯ�õ���ʵ������
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
