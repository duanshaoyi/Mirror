package com.mirror.Dao;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> {

	/**
     * 按照主键查找
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    
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
     * 删除
     *
     * @param entity
     */
    public void remove(T entity);
    
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
}
