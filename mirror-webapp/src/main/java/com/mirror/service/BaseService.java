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
    * ����ID����
    *
    * @param paramID
    * @return T
    */
   public T find(ID paramID);

   /**
    * ����ȫ��
    *
    * @return the list
    */
   public List<T> findAll();
   
   /**
    * ��ID���ϲ���
    *
    * @param ids the ids
    * @return the list
    */
   public abstract List<T> findList(ID... ids);
   
   /**
    * ����
    *
    * @param entity the entity
    */
   public void save(T entity);
   
   /**
    * ����
    *
    * @param entity the entity
    * @return the t
    */
   public abstract T update(T entity);
   
   /**
    * ɾ��
    *
    * @param id the id
    */
   public void delete(ID id);
   
   /**
    * ɾ��ȫ��
    *
    * @param ids the ids
    */
   public void delete(ID... ids);

   /**
    * ɾ��
    *
    * @param entity the entity
    */
   public void delete(T entity);
}
