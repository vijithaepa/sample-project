package com.digitali.business.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digitali.business.contract.UserManagerContract;
import com.digitali.dao.contract.UserDaoContract;
import com.digitali.entity.User;
import com.digitali.util.CryptUtil;

public class UserManager implements UserManagerContract {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public UserDaoContract userDao;

	public User create(User user) {
		String password = user.getPassword();
		user.setPassword(CryptUtil.getInstance().encryptBase64String(password));
		User savedUser = userDao.create(user);
		logger.info(" # SAVED USER IS : " + savedUser.getUserId());
		// notifyUser(user);
		logger.info(" # User Notified with an eMail : " + savedUser.getEmail());
		return savedUser;
	}

	public User update(User entity) {
		return userDao.update(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public User delete(User entity) {
		User user = userDao.get(entity.getUserId());
		return userDao.delete(user);
	}

	public User get(Long entityId) {
		User user = userDao.get(entityId);
		return user;
	}

	public User findByEmail(String email) {
		User user = userDao.findByEmail(email);
		return user;
	}

	public User findByCredentials(String userName, String password) {
		return userDao.findByCredentials(userName, CryptUtil.getInstance().encryptBase64String(password));
	}
}