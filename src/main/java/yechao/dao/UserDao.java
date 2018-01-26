package yechao.dao;

import scala.UserScala;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScala user);

    int insertSelective(UserScala user);

    UserScala selectByPrimaryKey(Integer id);

    UserScala selectByUserName(String name);

    Integer selectByName(String name);

    UserScala selectByNameAndPassword(UserScala user);

    int updateByPrimaryKeySelective(UserScala user);

    int updateByPrimaryKey(UserScala user);
}