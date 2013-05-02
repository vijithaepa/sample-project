package com.digitali.business.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.digitali.business.contract.UserManagerContract;
import com.digitali.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-serviceContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserManager {

	@Autowired(required = true)
	public UserManagerContract userManager;

	private static User newUser;
	private static User persistUser;
	private static String newEMailAdress = "updated@abc.com";

	@Before
	public void setup(){
		newUser = getNewUser();
	}
	
	@Test
	public void atestCreateUser() {
		User savedUser = userManager.create(newUser);
		Assert.assertNotNull(savedUser.getUserId());
	}

	@Test
	public void btestGetUser() {
		persistUser = userManager.get(1L);
		Assert.assertNotNull(persistUser);
		Assert.assertEquals(newUser.getEmail(), persistUser.getEmail());
	}

	@Test
	public void ctestUpdate() {
		persistUser.setEmail(newEMailAdress);
		User updatedUser = userManager.update(persistUser);
		Assert.assertEquals(newEMailAdress, updatedUser.getEmail());
	}

	@Test
	public void dtestFindByEmail() {
		User user = userManager.findByEmail(newEMailAdress);
		Assert.assertEquals(newEMailAdress, user.getEmail());
	}

	@Test
	public void etestFindByCredentials() {
		User user = userManager.findByCredentials(newUser.getUsername(), newUser.getPassword());
		Assert.assertNotNull(user);
		Assert.assertEquals(newUser.getUsername(), user.getUsername());
	}

	@Ignore
	public void ftestDelete() {
		User deletedUser = userManager.delete(persistUser);
		Assert.assertNotNull(deletedUser);
	}

	private static User getNewUser() {
		User user = new User();
		user.setFullName("Nandika Epa");
		user.setUsername("vijitha");
		user.setPassword("epa123");
		user.setAge(20);
		user.setEmail("testing@sdf.com");
		user.setGender("M");
		user.setPhoneNo("237463249");
		return user;
	}
}
