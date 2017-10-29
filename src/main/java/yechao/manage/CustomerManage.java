package yechao.manage;

import yechao.basic.Response;
import yechao.model.CustomerVo;
import yechao.model.Customer;

public interface CustomerManage {
	
	public Response<Customer> InsertCustomer(Customer customer);

}
