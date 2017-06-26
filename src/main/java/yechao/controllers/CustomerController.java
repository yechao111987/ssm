package yechao.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yechao.model.customers;
import yechao.service.CustomerService;

@Controller
@RequestMapping("/user")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		customers user = this.customerService.getCustomerByid(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/deleteUser")
	public void toDeleteById(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		 this.customerService.deleteByid(userId);
	}

}
