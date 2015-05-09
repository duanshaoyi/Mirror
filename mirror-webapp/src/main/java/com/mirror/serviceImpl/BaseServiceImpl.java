package com.mirror.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mirror.service.BaseService;

@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>{

	@Override
	public Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T find(ID paramID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findList(ID... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ID... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

}
