package yechao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import yechao.model.User;

import com.alibaba.fastjson.JSON;

public class UserDao {
	
	public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/demo";
		String username="root";
		String password="yechao";
		DataSource dataSource = new DriverManagerDataSource(driverClassName, url, username, password);
		NamedParameterJdbcTemplate name = new NamedParameterJdbcTemplate(
				dataSource);
		return name;
	}

	public static void main(String[] args) {
//		System.out.println(getNamedParameterJdbcTemplate().toString());
//		
//
//		String driverClassName="com.mysql.jdbc.Driver";
//		String url="jdbc:mysql://127.0.0.1:3306/demo";
//		String username="root";
//		String password="yechao";
//		DataSource dataSource = new DriverManagerDataSource(driverClassName, url, username, password);
//		NamedParameterJdbcTemplate name = new NamedParameterJdbcTemplate(
//				dataSource);
//		System.out.println(name.toString());
//		Map<String, Object>  paramMap=new HashMap<String, Object>();
//		paramMap.put("id", "1");
//		String sql="select * from users where id=:id";
//		List<Map<String,Object>> result=name.queryForList(sql, paramMap);
//		System.out.println(JSON.toJSONString(result));
//		System.out.println(result.size());

		UserService userService=new UserServiceImpl();
		User user=userService.getUser("1");
		System.out.println(user.getName());


	}

}
