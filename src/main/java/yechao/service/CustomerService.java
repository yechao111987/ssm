package yechao.service;

import org.springframework.stereotype.Service;

import yechao.model.CustomerVo;
import yechao.model.Customer;

//@Service
public interface CustomerService {
	public Customer getCustomerByid(int id);

	public void deleteByid(int id);

	public void insertUser(Customer customer);

}
