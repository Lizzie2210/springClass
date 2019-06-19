package kr.woongjin.hellospring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.woongjin.hellospring.dao.UserDao;
import kr.woongjin.hellospring.model.User;
import kr.woongjin.hellospring.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserDao userDao;
	
	public User searchUserByUserId(Integer userId){
		return userDao.selectUserByKey(userId); 
	}
	
	public List<User> searchUsers(){
		return userDao.selectAllUsers();
	}

	@Override
	public User registUser(User user) { 
		return userDao.insertUser(user);
	}
}
