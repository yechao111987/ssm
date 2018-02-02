package yechao.service;

import org.springframework.stereotype.Service;

import yechao.basic.PageForm;
import yechao.basic.Response;
import yechao.model.CustomerVo;
import yechao.model.Customer;

//@Service
public interface CustomerService {
    public Response<Customer> getCustomerByid(int id);

    public void deleteByid(int id);

    public void insertUser(Customer customer);

    public PageForm listByPage(int currentPage, int pageSize);

}
