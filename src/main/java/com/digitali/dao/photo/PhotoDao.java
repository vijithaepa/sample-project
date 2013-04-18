package com.digitali.dao.photo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitali.dao.contract.PhotoDaoContract;
import com.digitali.entity.Photo;
import com.digitali.entity.User;

public class PhotoDao implements PhotoDaoContract {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	public Photo create(Photo entity) {
		em.persist(entity);
		return entity;
	}

	public Photo update(Photo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo delete(Photo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo get(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Photo> getAll(User user) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Photo> criteria = builder.createQuery(Photo.class);
		Root<Photo> photo = criteria.from(Photo.class);

		criteria.where(builder.equal(photo.get("createdUser"), user));
		criteria.select(photo).orderBy(builder.asc(photo.get("createdDate")));
		return em.createQuery(criteria).getResultList();
	}

}
