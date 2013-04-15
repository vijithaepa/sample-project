package com.digitali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.digitali.business.photo.TestPhotoManager;
import com.digitali.business.user.TestUserManager;
import com.digitali.util.TestPhotoUtil;

@RunWith(Suite.class)
@SuiteClasses({ TestUserManager.class, TestPhotoUtil.class, TestPhotoManager.class })
public class TestAll {

}
