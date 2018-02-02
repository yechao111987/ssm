package yechao.dao;

import yechao.model.Customer;

import java.util.List;


public interface CustomersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer customer);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Integer countCustomer();

    List<Customer> queryByPage(Integer start, Integer end);
}