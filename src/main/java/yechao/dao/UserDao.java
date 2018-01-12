package yechao.dao;

import scala.UserScala;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScala user);

    int insertSelective(UserScala user);

    UserScala selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserScala user);

    int updateByPrimaryKey(UserScala user);
}