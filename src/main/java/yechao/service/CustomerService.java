package yechao.service;

import org.springframework.stereotype.Service;

import yechao.model.CustomerVo;
import yechao.model.customers;
@Service
public interface CustomerService {
	public customers getCustomerByid(int id);
	
	public void deleteByid(int id);
	
	public void insertUser(customers customer);
	

}
