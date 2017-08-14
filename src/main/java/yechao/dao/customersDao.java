package yechao.dao;

import yechao.model.CustomerVo;
import yechao.model.customers;

public interface customersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(customers customer);

    int insertSelective(customers record);

    customers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(customers record);

    int updateByPrimaryKey(customers record);
}