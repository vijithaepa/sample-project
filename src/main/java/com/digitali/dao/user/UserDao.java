package com.digitali.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitali.dao.contract.UserDaoContract;
import com.digitali.entity.User;

@Repository
@Transactional
public class UserDao implements UserDaoContract {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	@PersistenceContext
	private EntityManager em;

	@Override
	public User create(User user) {
		em.persist(user);
		logger.debug("User - " + user.getUsername() + " Created");
		return user;
	}

	@Override
	public User update(User user) {
		User updatedUser = em.merge(user);
		return updatedUser;
	}

	@Override
	public User delete(User user) {
		em.remove(user);
		return user;

	}

	@Override
	public User get(Long userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User findByEmail(String email) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> user = criteria.from(User.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(user).orderBy(cb.asc(user.get(User_.name)));
		 */

		criteria.select(user).where(builder.equal(user.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<User> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> user = criteria.from(User.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(user).orderBy(cb.asc(user.get(User_.name)));
		 */
		criteria.select(user).orderBy(cb.asc(user.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public User findByCredentials(String userName, String password) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> user = criteria.from(User.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(user).orderBy(cb.asc(user.get(User_.name)));
		 */

		criteria.where(builder.equal(user.get("username"), userName));
		criteria.where(builder.and(builder.equal(user.get("password"), password)));
		return em.createQuery(criteria).getSingleResult();

	}

}