package kr.woongjin.hellospring.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value=BizException.class)
	public Map<String,Object> hadleBizExeption(BizException e ) {
		Map<String,Object> map = new HashMap<>();
		map.put("error", true);
		map.put("msg", e.getMessage());
		map.put("error_code", 120);
		return map;
		
	} 
	@ExceptionHandler(value=SQLException.class)
	public Map<String,Object> hadleSQLExeption(SQLException e ) {
		Map<String,Object> map = new HashMap<>();
		map.put("error", true);
		map.put("msg", e.getMessage());
		map.put("error_code", 120);
		return map;
		
	} 
	/*
	 * {
	 * 	"error": true ,
	 * 	"msg" : "you have an error in your sql syntax"
	 *  "error_code" : 120
	 * 
	 * }
	 */
	@ExceptionHandler(value=NumberFormatException.class)
	public String hadleNumberFormatExeption(NumberFormatException e ) {
		return e.getMessage();
		
	}
	
	//모든 예외의 아버지 Exception은 가장 마지막에 존재해야한다. 
	@ExceptionHandler(value=Exception.class)
	public String hadleExeption(Exception e) {
		return e.getMessage();
		
	}
	
	
	
}
