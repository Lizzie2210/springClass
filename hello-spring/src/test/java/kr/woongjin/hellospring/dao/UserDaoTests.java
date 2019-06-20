package kr.woongjin.hellospring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
import kr.woongjin.hellospring.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
//모든 테스트 케이스는 public void임
//명칭은 아래와 같이 testInsert~ 여햐함. 
//테스트케이스의 기준을 잡아야함.
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsertUser(){
		//1. insert 해서 에러가 없으면 성공 
		//2. 내가 넣은 데이터와 반환 데이터가 같으면 성공
		User user = new User(500,"test",2);
		User returned = userDao.insertUser(user);
		Assert.assertTrue(user.getUserId()==returned.getUserId());
		Assert.assertNotNull(returned);
		
	}
}
