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

	private static final String SRC__IMAGE = "src/main/webapp/jsp/images/gallery/Ant_01.jpg";
	
	@Autowired(required = true)
	PhotoUtil photoUtil;

	@Before
	public void setup() {

	}

	public void createFile() {
		File file = new File(SRC__IMAGE);
		Assert.assertTrue(file.exists());
	}

	@Test
	public void testStoreImage() {
		Photo photo = getNewPhoto();
		photoUtil.storeImage(photo.getBufferedFile(), photo.getImgName(), 2L);
		System.out.println("Photo Saved....");
	}

	private Photo getNewPhoto() {
		Photo photo = new Photo();
		photo.setCaption("Testing Caption");
		photo.setCategory("model");
		photo.setCreatedDate(new Date());
		photo.setDescription("Test description");

		File file = new File(SRC__IMAGE);

		photo.setBufferedFile(PhotoUtil.getBufferedImage(file));
		photo.setImgName("Ant_01.jpg");

		return photo;
	}

}
