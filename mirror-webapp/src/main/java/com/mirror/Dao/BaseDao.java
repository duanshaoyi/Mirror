package com.mirror.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	

	/**
     * ������������
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    /**
     * ��ȡ����entity
     *
     * @param entityClass
     * @return List<T> entity list
     */
	List<T> findAll(Class<T> entityClass);
    
    
    /**
     * ����
     *
     * @param entity
     */
    public void persist(T entity);
    
    /**
     * ����
     *
     * @param entity
     * @return T
     */
    public T merge(T entity);
    
    
    /**
     * ɾ��ʵ��
     *
     * @param entity
     */
    public void remove(T entity);
    
    
    /**
     * ����IDɾ��ʵ��
     *
     * @param entity
     */
    public void remove(T entity, ID id);   
    
    
    /**
     * ˢ������
     *
     * @param entity
     */
    public void refresh(T entity);
    
    /**
     * ��ȡ����
     *
     * @param entity
     * @return ID
     */
    public ID getIdentifier(T entity);
    
	  /**
     * ��ȡ����entity
     *
     * @param entityClass
     * @return count of entities
     */
	long findCount(Class<T> entityClass);
}
