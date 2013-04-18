package com.digitali.dao.contract;

import java.util.List;

import com.digitali.dao.EntityDao;
import com.digitali.entity.Photo;
import com.digitali.entity.User;

public interface PhotoDaoContract extends EntityDao<Photo>{

	List<Photo> getAll(User user);

}
