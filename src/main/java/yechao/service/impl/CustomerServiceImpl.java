package yechao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yechao.basic.Response;
import yechao.dao.CustomersDao;
import yechao.model.Customer;
import yechao.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomersDao customerdao;

	@Override
	public Response<Customer> getCustomerByid(int id) {
		Response<Customer> response=new Response<Customer>();
		Customer cust=this.customerdao.selectByPrimaryKey(id);
		if (cust==null) {
			response.setCode("1");
			response.setMessage("数据不存在");
			return response;
		}
		response.setCode("0");
		response.setMessage("查询成功");
		response.setDataResult(cust);
		return response;
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
