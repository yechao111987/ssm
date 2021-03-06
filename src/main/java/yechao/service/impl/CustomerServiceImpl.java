package yechao.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import yechao.basic.PageForm;
import yechao.basic.Response;
import yechao.controllers.CustomerController;
import yechao.dao.CustomersDao;
import yechao.model.Customer;
import yechao.service.CustomerService;

import java.util.List;


@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomersDao customerdao;

    private final static Logger log = Logger.getLogger(CustomerServiceImpl.class);


    @Override
    public Response<Customer> getCustomerByid(int id) {
        Response<Customer> response = new Response<Customer>();
        Customer cust = this.customerdao.selectByPrimaryKey(id);
        if (cust == null) {
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

    @Override
    public PageForm listByPage(int currentPage, int pageSize) {
        PageForm pageForm = new PageForm<Customer>();
        List<Customer> list = null;
        Integer count = customerdao.countCustomer();
        int totalpage = count.intValue() / pageSize + 1;


        if (0 == count.intValue()) {
            pageForm.setTotalCount(0);
            return pageForm;
        }
        if (pageSize > count.intValue()) {
            pageForm.setTotalCount(count.intValue());
            pageForm.setPageSize(pageSize);
            list = customerdao.queryByPage(1, count);
            pageForm.setList(list);
            pageForm.setPageNum(currentPage);
            pageForm.setTotalPage(totalpage);
            return pageForm;
        }
        if (currentPage * pageSize <= count.intValue()) {
            list = customerdao.queryByPage((currentPage - 1) * pageSize, pageSize);
            log.info(JSON.toJSONString(list));
        } else {
            list = customerdao.queryByPage((currentPage - 1) * pageSize, pageSize);
        }
        pageForm.setList(list);
        pageForm.setTotalCount(count.intValue());
        pageForm.setPageNum(currentPage);
        pageForm.setPageSize(pageSize);
        pageForm.setTotalPage(totalpage);
        return pageForm;
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        if (1 == customerdao.updateByPrimaryKey(customer)) {
            log.info(customer.getId());
            return true;
        }
        return false;


    }

}
