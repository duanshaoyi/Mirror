package com.mirror.Dao;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> {

	/**
     * ������������
     *
     * @param id
     * @return T
     */
    public T find(ID id);
    
    
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
     * ɾ��
     *
     * @param entity
     */
    public void remove(T entity);
    
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
}
