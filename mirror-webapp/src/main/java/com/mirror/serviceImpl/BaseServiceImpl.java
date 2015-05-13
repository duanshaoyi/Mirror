package com.mirror.serviceImpl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mirror.Dao.BaseDao;
import com.mirror.service.BaseService;

@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>{

	private Map<String,PropertyDescriptor> propertyDescriptors ;
    /**
     *
     */
    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * The Entity class. service对应的Entity的类
     */
    private Class<T> entityClass;

    public BaseServiceImpl() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameterizedType = ((ParameterizedType) type)
                .getActualTypeArguments();
        entityClass = ((Class<T>) parameterizedType[0]);
        PropertyDescriptor[] ps = BeanUtils
                .getPropertyDescriptors(entityClass);
        propertyDescriptors = new HashMap<String, PropertyDescriptor>();
        // 建立反向查询PropertyDescriptor的table,属性名是大小写不敏感的
        for (PropertyDescriptor pd : ps) {
            propertyDescriptors.put(pd.getName().toLowerCase(), pd);
        }
    }

    /**
     * Get entity class. service对应的Entity的类
     *
     * @return the class
     */
    public Class<T> getEntityClass(){
       return entityClass;
    }
    public Map<String,PropertyDescriptor> getEntityPropertyDescriptors(){
        return propertyDescriptors;
    }
    public PropertyDescriptor getEntityPropertyDescriptor(String ignoredPropertyName){
        PropertyDescriptor pd = this.propertyDescriptors.get(ignoredPropertyName);
        if(pd==null){
            pd = this.propertyDescriptors.get(ignoredPropertyName.toLowerCase());
        }
        return pd;
    }
    @Override
    @Transactional(readOnly = true)
    public T find(ID id) {
        return baseDao.find(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return baseDao.findAll(entityClass);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findList(ID... ids) {
        ArrayList<T> resultList = new ArrayList<T>();
        if (ids != null) {
            for (ID id : ids) {
                T t = find(id);
                if (t != null) {
                    resultList.add(t);
                }
            }
        }
        return resultList;
    }

    @Override
    @Transactional
    public void save(T entity) {
        baseDao.persist(entity);
    }
    @Override
    @Transactional
    public T update(T entity) {
        return baseDao.merge(entity);
    }
   
    @Override
    @Transactional
    public void delete(ID id) {
        delete(baseDao.find(id));
    }
    @Override
    @Transactional
    public void delete(ID... ids) {
        if (ids != null) {
            for (ID id : ids) {
                delete(baseDao.find(id));
            }
        }
    }
    @Override
    @Transactional
    public void delete(T entity) {
        baseDao.remove(entity);
    }

    private void copyProperties(Object source, Object target,
                                String[] ignoreProperties) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        PropertyDescriptor[] propertyDescriptors = BeanUtils
                .getPropertyDescriptors(target.getClass());
        List<String> ignorePropertieList = ignoreProperties != null ? Arrays
                .asList(ignoreProperties) : null;
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if ((propertyDescriptor.getWriteMethod() != null)
                    && ((ignoreProperties == null) || (!ignorePropertieList
                    .contains(propertyDescriptor.getName())))) {
                PropertyDescriptor sourcePropertyDescriptor = BeanUtils
                        .getPropertyDescriptor(source.getClass(),
                                propertyDescriptor.getName());
                if ((sourcePropertyDescriptor != null)
                        && (sourcePropertyDescriptor.getReadMethod() != null)) {
                    try {
                        Method sourceReadMethod = sourcePropertyDescriptor
                                .getReadMethod();
                        if (!Modifier.isPublic(sourceReadMethod
                                .getDeclaringClass().getModifiers())) {
                            sourceReadMethod.setAccessible(true);
                        }
                        Object sourceObject = sourceReadMethod.invoke(source,
                                new Object[0]);
                        Object targetObject = sourceReadMethod.invoke(target,
                                new Object[0]);
                        if ((sourceObject != null) && (targetObject != null)
                                && ((targetObject instanceof Collection))) {
                            Collection targetCollection = (Collection) targetObject;
                            targetCollection.clear();
                            targetCollection.addAll((Collection) sourceObject);
                        } else {
                            Method targetWriteMethod = propertyDescriptor
                                    .getWriteMethod();
                            if (!Modifier.isPublic(targetWriteMethod
                                    .getDeclaringClass().getModifiers())) {
                                targetWriteMethod.setAccessible(true);
                            }
                            targetWriteMethod.invoke(target,
                                    new Object[]{targetObject});
                        }
                    } catch (Throwable t) {
                        throw new FatalBeanException(
                                "Could not copy properties from source to target",
                                t);
                    }
                }
            }
        }
    }

}
