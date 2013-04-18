package com.digitali.business.contract;

import java.util.Set;

import com.digitali.business.EntityManager;
import com.digitali.entity.Photo;

public interface PhotoManagerContract extends EntityManager<Photo> {

	Set<Photo> getAll(long userId);

}
