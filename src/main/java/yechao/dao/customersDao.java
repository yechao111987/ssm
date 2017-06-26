package yechao.dao;

import yechao.model.customers;

public interface customersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(customers record);

    int insertSelective(customers record);

    customers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(customers record);

    int updateByPrimaryKey(customers record);
}