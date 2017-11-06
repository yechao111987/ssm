package yechao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yechao.dao.CustomersDao;
import yechao.model.CustomerVo;
import yechao.model.Customers;
import yechao.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomersDao customerdao;

	@Override
	public Customers getCustomerByid(int id) {
		Customers cust=this.customerdao.selectByPrimaryKey(id);
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
	public void insertUser(Customers customer) {
		this.customerdao.insert(customer);
		
	}

	@Override
	public void insertCustomerVo(CustomerVo customer) {
		// TODO Auto-generated method stub
		this.customerdao.insertCustomerVo(customer);
		
	}

}
