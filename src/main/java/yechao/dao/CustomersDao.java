package yechao.dao;

import yechao.model.CustomerVo;
import yechao.model.Customers;

public interface CustomersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Customers customer);
    
    int insertCustomerVo(CustomerVo customervo);


    int insertSelective(Customers record);

    Customers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customers record);

    int updateByPrimaryKey(Customers record);
}