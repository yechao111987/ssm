package yechao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import yechao.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = UserDao
				.getNamedParameterJdbcTemplate();
		Map<String, Object>  paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		String sql="select * from users where id=:id";
		List<Map<String,Object>> result=namedParameterJdbcTemplate.queryForList(sql, paramMap);
		Map<String, Object> map=new HashMap<String, Object>();
		map=result.get(0);
		User user=new User();
		user.setId((Integer)map.get("id"));
		user.setName((String)map.get("name"));
		user.setAge((Integer)map.get("age"));
		user.setAddress((String)map.get("address"));
		return user;
	}

	@Override
	public Integer checkUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
