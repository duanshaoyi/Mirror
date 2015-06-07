package com.mirror.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	

	/**
     * ����id����entity
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    /**
     * ��������entity
     *
     * @param entityClass
     * @return List<T> entity list
     */
	List<T> findAll(Class<T> entityClass);
    
    
    /**
     * ����entity
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
     * ɾ��
     *
     * @param entity
     */
    public void remove(T entity);
    
    
    /**
     * ����idɾ��ʵ��
     *
     * @param entity
     */
    public void remove(T entity, ID id);   
    
    
    /**
     * ˢ��ʵ��
     *
     * @param entity
     */
    public void refresh(T entity);
    
    /**
     * ��ȡʵ��id
     *
     * @param entity
     * @return ID
     */
    public ID getIdentifier(T entity);
    
	  /**
     * 
     *
     * @param entityClass
     * @return count of entities
     */
	long findCount(Class<T> entityClass);
}
