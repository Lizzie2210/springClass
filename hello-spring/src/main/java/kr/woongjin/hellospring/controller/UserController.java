package kr.woongjin.hellospring.controller;
  
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.woongjin.hellospring.model.User;
import kr.woongjin.hellospring.service.UserService;
 

@Controller 
public class UserController  {
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/greet")
	@ResponseBody // 응답 자체를 jsp 말고 바디 자체를 응답해주세요.
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/users")//사용자 전체보기 
	@ResponseBody
	public List<User> getAllUsers(@RequestParam(defaultValue="0") int userId,
								  @RequestParam(value="page",defaultValue="0") int page){ 
		System.out.println(userId +" " +page);
		return userService.searchUsers();
	}
	
	//사용자 상세보기
	@GetMapping("/users/{userId}")
	@ResponseBody
	public User getUsersById(@PathVariable Integer userId){ //어차피 호출은 url이기 때문에 메소드 이름 자체를 설명적으로 만든다.//주석대신! 
			System.out.println(userId + " .. from path variable");
		return userService.searchUserByUserId(userId);
	}
	/*
	//사용자 등록 - 포스트 방식
	@PostMapping("/users")
	@ResponseBody
	public User registUser(@RequestParam Integer userId
						  ,@RequestParam String userName
						  ,@RequestParam Integer age  
							) {
		
		return new User(userId,userName,age);
	}*/
	//사용자 등록 -json 방식
	@PostMapping("/users")
	@ResponseBody
	public User registUser(@RequestBody User user ) { 
		return  user;
	}
	//사용자 삭제
	//사용자 수정
	
}
