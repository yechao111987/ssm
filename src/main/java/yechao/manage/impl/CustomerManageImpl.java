package yechao.manage.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yechao.basic.Response;
import yechao.dao.CustomersDao;
import yechao.manage.CustomerManage;
import yechao.model.Customer;
import yechao.service.CustomerService;

@Service
public class CustomerManageImpl implements CustomerManage {

	@Resource
	private CustomerService customerService;

	@Resource
	private CustomersDao customersDao;

	@Override
	public Response<Customer> InsertCustomer(Customer customerVo) {
		// TODO Auto-generated method stub
		Response<Customer> response = new Response<Customer>();
		if (null == customerVo.getName()) {
			response.setCode("1");
			response.setMessage("用户名为空");
			return response;

		}

		if (null == customerVo.getAddress()) {
			response.setCode("1");
			response.setMessage("地址为空");
			return response;
		}
		if (null == customerVo.getPhone()) {
			response.setCode("1");
			response.setMessage("电话号码为空");
			return response;
		}
		this.customersDao.insert(customerVo);
		response.setCode("0");
		response.setMessage("数据插入成功");
		response.setDataResult(customerVo);
		return response;
	}

}
