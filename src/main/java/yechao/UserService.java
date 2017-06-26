package yechao;

import yechao.model.User;

public interface UserService {
	public User getUser(String id);
	public Integer checkUser(String name);
}
