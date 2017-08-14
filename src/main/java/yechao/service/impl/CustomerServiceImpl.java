package yechao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yechao.dao.customersDao;
import yechao.model.customers;
import yechao.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private customersDao customerdao;

	@Override
	public customers getCustomerByid(int id) {
		customers cust=this.customerdao.selectByPrimaryKey(id);
		if (cust==null) {
			return null;
		}
		return cust;
	}

	@Override
	public void deleteByid(int id) {
		this.customerdao.deleteByPrimaryKey(id);
	}

}
