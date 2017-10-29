package yechao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yechao.dao.CustomersDao;
import yechao.model.Customer;
import yechao.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomersDao customerdao;

	@Override
	public Customer getCustomerByid(int id) {
		Customer cust=this.customerdao.selectByPrimaryKey(id);
		if (cust==null) {
			return null;
		}
		return cust;
	}

	@Override
	public void deleteByid(int id) {
		this.customerdao.deleteByPrimaryKey(id);
	}

	@Override
	public void insertUser(Customer customer) {
		this.customerdao.insert(customer);
		
	}

}
