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
		return this.customerdao.selectByPrimaryKey(id);
	}

	@Override
	public void deleteByid(int id) {
		this.customerdao.deleteByPrimaryKey(id);
	}

}
