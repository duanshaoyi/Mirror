package com.mirror.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	

	/**
     * 按照主键查找
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    /**
     * 获取所有entity
     *
     * @param entityClass
     * @return List<T> entity list
     */
	List<T> findAll(Class<T> entityClass);
    
    
    /**
     * 新增
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
     * 删除实体
     *
     * @param entity
     */
    public void remove(T entity);
    
    
    /**
     * 根据ID删除实体
     *
     * @param entity
     */
    public void remove(T entity, ID id);   
    
    
    /**
     * 刷新数据
     *
     * @param entity
     */
    public void refresh(T entity);
    
    /**
     * 获取主键
     *
     * @param entity
     * @return ID
     */
    public ID getIdentifier(T entity);
    
	  /**
     * 获取所有entity
     *
     * @param entityClass
     * @return count of entities
     */
	long findCount(Class<T> entityClass);
}
