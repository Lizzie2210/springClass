package kr.woongjin.hellospring.service;

import java.util.List;

import kr.woongjin.hellospring.model.User;

public interface UserService {
	public User searchUserByUserId(Integer userId); 
	public List<User> searchUsers();
	
}
