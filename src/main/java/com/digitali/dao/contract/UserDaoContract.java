package com.digitali.dao.contract;

import java.util.List;

import com.digitali.entity.EntityDao;
import com.digitali.entity.User;

public interface UserDaoContract extends EntityDao<User> {

	/**
	 * Find {@link User} by emailAddress.
	 * 
	 * @param email as {@link String}.
	 * @return type {@link User}.
	 */
	User findByEmail(String email);

	/**
	 * Find all {@link User}s ordered by Name.
	 * 
	 * @return {@link List} of {@link User}s.
	 */
	List<User> findAllOrderedByName();

	/**
	 * Find all {@link User}s for the given UserName and Password.
	 * 
	 * @param userName as {@link String}.
	 * @param password as {@link String}.
	 * @return {@link List} of {@link User}s.
	 */
	User findByCredentials(String userName, String password);

}
