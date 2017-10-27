package yechao.service;

import org.springframework.stereotype.Service;

import yechao.model.CustomerVo;
import yechao.model.Customers;

@Service
public interface CustomerService {
	public Customers getCustomerByid(int id);

	public void deleteByid(int id);

	public void insertUser(Customers customer);

}
