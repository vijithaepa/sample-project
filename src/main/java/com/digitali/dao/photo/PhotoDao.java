package com.digitali.dao.photo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitali.dao.contract.PhotoDaoContract;
import com.digitali.entity.Photo;

public class PhotoDao implements PhotoDaoContract {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public Photo create(Photo entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Photo update(Photo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo delete(Photo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo get(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
