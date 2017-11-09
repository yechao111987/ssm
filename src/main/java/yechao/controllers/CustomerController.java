package yechao.controllers;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import yechao.basic.Response;
import yechao.manage.CustomerManage;
import yechao.model.Customer;
import yechao.model.CustomerVo;
import yechao.service.CustomerService;

@Controller
@RequestMapping("/user")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	@Resource
	private HttpServletRequest request;
	// @Resource
	// private Response<Customers> response;
	@Resource
	private CustomerManage customerManage;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toList() {
		ModelAndView modelAndView = new ModelAndView("test/list");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		// modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);

		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public String toTest() {
		ModelAndView modelAndView = new ModelAndView("test/list");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		// modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);
		String jsonString = JSON.toJSONString(modelMap);
		System.out.println(jsonString);

		return jsonString;

	}

	@ResponseBody
	@RequestMapping("/list3")
	public JSONObject list(ModelMap modelMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AAA", "1212");
		JSONObject aa = (JSONObject) JSON.toJSON(map);
		return aa;
	}

	@ResponseBody
	@RequestMapping("/list4")
	public Map<String, Object> list4(ModelMap modelMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AAA", "1212");
		return map;
	}

	// headers="Content-Type=text/plain"
	// @RequestMapping(value = "/showUser", method = RequestMethod.GET, headers
	// = "ContentType1=text_plain11")
	// public String toIndex(@RequestParam("id") Integer userId, Model model) {
	// // int userId = Integer.parseInt(request.getParameter("id"));
	// Customer user = this.customerService.getCustomerByid(userId);
	// if (user == null) {
	// model.addAttribute("user", "用户不存在");
	// return "showUser";
	// }
	// model.addAttribute("user", user.getName());
	// return "showUser";
	// }

	@ResponseBody
	@RequestMapping(value = "/showUser1", method = RequestMethod.GET)
	public Response<Customer> toIndex2(Model model) {
		Response<Customer> response = new Response<Customer>();
		if (null == request.getParameter("id") || request.getParameter("id")=="" ) {
			response.setCode("1");
			response.setMessage("id为空");
		}
		int userId = Integer.parseInt(request.getParameter("id"));
		response = this.customerService.getCustomerByid(userId);
		if (response.getCode().equals("0") && response.getDataResult() != null) {
			return response;
		}
		return response;
	}

	@RequestMapping("/deleteUser")
	public void toDeleteById(Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		this.customerService.deleteByid(userId);
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView toDemo() {
		ModelAndView modelAndView = new ModelAndView("test/demo");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		// modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public Customer toAddCustomer(Model model) {
		Customer customerVo = new Customer();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		// String id=request.getParameter("id");
		customerVo.setName(name);
		customerVo.setPhone(phone);
		customerVo.setAddress(address);
		// customerVo.setId(Integer.valueOf(id));
		this.customerService.insertUser(customerVo);
		return customerVo;
	}

	@ResponseBody
	@RequestMapping(value = "/addUserByManage", method = RequestMethod.GET)
	public Response<Customer> toAddCustomerByManage(Model model) {
		Customer customer = new Customer();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		// String id=request.getParameter("id");
		customer.setName(name);
		customer.setPhone(phone);
		customer.setAddress(address);
		// customerVo.setId(Integer.valueOf(id));

		Response<Customer> response = new Response<Customer>();
		response = customerManage.InsertCustomer(customer);
		// this.customerService.insertUser(customer);
		return response;
	}

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public ModelAndView toExample() {
		ModelAndView modelAndView = new ModelAndView("test/example");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		// modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);

		return modelAndView;

	}

}
