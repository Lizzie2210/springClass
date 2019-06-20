package kr.woongjin.hellospring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.woongjin.hellospring.exception.BizException;
import kr.woongjin.hellospring.model.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//db연동 에이전시  mybatis에는 세션 템플릿이 존재한다. 
	
	public User selectUserByKey(Integer userId) {
		String sql = "SELECT * FROM USER WHERE USERID = ? ";
		User user = null;
		try {
			//데이터 확보 from anywhere 
			 user = jdbcTemplate.queryForObject(sql,new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					return new User(rs.getInt(1),rs.getString(2),rs.getInt(3));
				}
				
			},userId);//하나데이터 조회
		}catch(DataAccessException e) {
			throw new BizException("사용자 상세조회 에러",e);
		}
		
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

	public User insertUser(User user) {
		String sql = "INSERT INTO spring.user(userId,userName,age) VALUES (?,?,?)";
		jdbcTemplate.update(sql,user.getUserId(),user.getUserName(),user.getAge());//update 함수로 delele,create,update가능
		return user;
	}
}
