package com.digitali.business.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digitali.business.contract.PhotoManagerContract;
import com.digitali.dao.contract.PhotoDaoContract;
import com.digitali.dao.contract.UserDaoContract;
import com.digitali.entity.Photo;
import com.digitali.entity.User;
import com.digitali.util.PhotoUtil;

public class PhotoManager implements PhotoManagerContract {

	@Autowired
	private PhotoDaoContract photoDao;
	
	@Autowired
	private UserDaoContract userDao;

	@Autowired
	private PhotoUtil photoUtil;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Photo create(Photo entity) {
		User user = userDao.get(entity.getCreatedUser().getUserId());
		entity.setCreatedUser(user);
		Photo photo = photoDao.create(entity);
		photoUtil.storeImage(entity.getBufferedFile(), entity.getImgName(), entity.getCreatedUser().getUserId());
		return photo;
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
