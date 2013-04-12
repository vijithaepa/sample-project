package com.digitali.business.contract;

import com.digitali.business.EntityManager;
import com.digitali.entity.User;

public interface UserManagerContract extends EntityManager<User> {

	User findByEmail(String email);

	User findByCredentials(String userName, String password);

}
