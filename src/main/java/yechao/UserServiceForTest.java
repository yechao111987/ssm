package yechao;

import yechao.model.User;

public interface UserServiceForTest {
	public User getUser(String id);
	public Integer checkUser(String name);
}
