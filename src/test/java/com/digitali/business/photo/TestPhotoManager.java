package com.digitali.business.photo;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.digitali.business.contract.PhotoManagerContract;
import com.digitali.entity.Photo;
import com.digitali.entity.User;
import com.digitali.util.PhotoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-serviceContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPhotoManager {

	private static final String SRC_IMAGE = "src/main/webapp/jsp/images/gallery/Dragon_Fly.jpg";
	@Autowired(required = true)
	private PhotoManagerContract photoManager;

	@Before
	public void init() {

	}

	@Test
	public void testCreatePhoto() {
		Photo photo = getNewPhoto();
		Photo savedPhoto = photoManager.create(photo);
		Assert.assertNotNull(savedPhoto);
	}

	@Test
	public void testGetAllPhotoes() {
		Set<Photo> photoList = photoManager.getAll(1L);
		Assert.assertNotNull(photoList);
		System.out.println("$$$$ : " + photoList.size());
		Assert.assertTrue(photoList.size() > 0);
	}

	private Photo getNewPhoto() {
		Photo photo = new Photo();
		photo.setCaption("Testing Caption");
		photo.setCategory("model");
		photo.setCreatedDate(new Date());
		photo.setDescription("Test description");

		File file = new File(SRC_IMAGE);
		photo.setBufferedFile(PhotoUtil.getBufferedImage(file));
		photo.setImgName("Ant_01.jpg");

		User user = new User();
		user.setUserId(1L);
		photo.setCreatedUser(user);

		return photo;
	}
}
