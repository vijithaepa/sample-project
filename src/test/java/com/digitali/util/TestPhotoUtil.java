package com.digitali.util;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.digitali.entity.Photo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-serviceContext.xml" })
public class TestPhotoUtil {

	@Autowired(required = true)
	PhotoUtil photoUtil;

	@Before
	public void setup() {
		System.out.println("############ " + photoUtil.getBaseLocation());
		System.out.println("############ " + photoUtil.getImageURI());
	}

	public void createFile() {
		File file = new File("src/main/webapp/images/gallery/Ant_01.jpg");
		Assert.assertTrue(file.exists());
	}

	@Test
	public void testStoreImage() {
		Photo photo = getNewPhoto();
		photoUtil.storeImage(photo.getFile(), photo.getImgName(), 2L);

		System.out.println("Photo Saved....");
	}

	private Photo getNewPhoto() {
		Photo photo = new Photo();
		photo.setCaption("Testing Caption");
		photo.setCategory("model");
		photo.setCreatedDate(new Date());
		photo.setDescription("Test description");

		File file = new File("src/main/webapp/images/gallery/Ant_01.jpg");

		photo.setFile(PhotoUtil.getBufferedImage(file));
		photo.setImgName("Ant_01.jpg");

		return photo;
	}

}
