package kr.woongjin.hellospring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.woongjin.hellospring.model.User;

@Repository
public class UserDao {
	public User selectUserByKey(Integer userId) {
		//데이터 확보 from anywhere 
		User user = new User(userId,"김순곤", 40);
		return user;
	}
	
	public List<User> selectAllUsers(){
		List<User> listOfUser = new ArrayList<>();
		listOfUser.add(new User(1,"김순곤", 40));
		listOfUser.add(new User(2,"홍길동", 20));
		listOfUser.add(new User(3,"lee", 30));
		listOfUser.add(new User(4,"kim", 20));
		listOfUser.add(new User(5,"yoon", 14));
		listOfUser.add(new User(6,"choi", 53));
		
		return listOfUser;
	}
}
