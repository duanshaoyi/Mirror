package com.mirror.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService <T, ID extends Serializable>{

	/**
    * Gets entity class.
    *
    * @return the entity class
    */
   public Class<T> getEntityClass();
   
   /**
    * 根据ID查找
    *
    * @param paramID
    * @return T
    */
   public T find(ID paramID);

   /**
    * 查找全部
    *
    * @return the list
    */
   public List<T> findAll();
   
   /**
    * 按ID集合查找
    *
    * @param ids the ids
    * @return the list
    */
   public abstract List<T> findList(ID... ids);
   
   /**
    * 创建
    *
    * @param entity the entity
    */
   public void save(T entity);
   
   /**
    * 更新
    *
    * @param entity the entity
    * @return the t
    */
   public abstract T update(T entity);
   
   /**
    * 删除
    *
    * @param id the id
    */
   public void delete(ID id);
   
   /**
    * 删除全部
    *
    * @param ids the ids
    */
   public void delete(ID... ids);

   /**
    * 删除
    *
    * @param entity the entity
    */
   public void delete(T entity);
}
