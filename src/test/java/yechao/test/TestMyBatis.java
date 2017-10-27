package yechao.test;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import yechao.model.Customers;
import yechao.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	private ApplicationContext ac = null;

	@Resource
	private CustomerService customerService;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		customerService = (CustomerService) ac.getBean("CustomerService");
	}

	@Test
	public void test1() {
		// System.out.println(JSON.toJSONString(customerService));
		Customers customer = customerService.getCustomerByid(2);
		System.out.println(customer.getName());
		logger.info("客户姓名：：" + customer.getName());
		logger.info(JSON.toJSONString(customer));
		System.out.println(JSON.toJSONString(customer));
	}

}
