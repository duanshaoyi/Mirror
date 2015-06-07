package com.mirror.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	

	/**
     * 根据id查找entity
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    /**
     * 查找所有entity
     *
     * @param entityClass
     * @return List<T> entity list
     */
	List<T> findAll(Class<T> entityClass);
    
    
    /**
     * 插入entity
     *
     * @param entity
     */
    public void persist(T entity);
    
    /**
     * 更新
     *
     * @param entity
     * @return T
     */
    public T merge(T entity);
    
    
    /**
     * 删除
     *
     * @param entity
     */
    public void remove(T entity);
    
    
    /**
     * 根据id删除实体
     *
     * @param entity
     */
    public void remove(T entity, ID id);   
    
    
    /**
     * 刷新实体
     *
     * @param entity
     */
    public void refresh(T entity);
    
    /**
     * 获取实体id
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
