package kr.woongjin.hellospring.serviceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.woongjin.hellospring.dao.UserDao;
import kr.woongjin.hellospring.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void searchUserByUserId(){
		User returned  = userDao.selectUserByKey(2); 
		Assert.assertTrue(2 == returned.getUserId());
		Assert.assertNotNull(returned);
	}
}
