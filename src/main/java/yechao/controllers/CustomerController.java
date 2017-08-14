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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import yechao.model.customers;
import yechao.service.CustomerService;

@Controller
@RequestMapping("/user")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	@Resource
	private HttpServletRequest request;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView  toList(){
		ModelAndView modelAndView=new ModelAndView("test/list");
		Map<String, Object> modelMap=new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		//modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);
		
		return modelAndView;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/list2",method=RequestMethod.GET)
	public String toTest(){
		ModelAndView modelAndView=new ModelAndView("test/list");
		Map<String, Object> modelMap=new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		//modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);
		String jsonString=JSON.toJSONString(modelMap);
		System.out.println(jsonString);
		
		return jsonString;
		
	}
	
	  @ResponseBody  
	  @RequestMapping("/list3")  
	  public JSONObject list(ModelMap modelMap) {  
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("AAA", "1212");
	    JSONObject aa=(JSONObject) JSON.toJSON(map); 
	    return  aa;  
	  }  
	  
	  @ResponseBody  
	  @RequestMapping("/list4")  
	  public Map<String, Object> list4(ModelMap modelMap) {  
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("AAA", "1212");
	    return  map;  
	  }
	  

	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	public String toIndex(@RequestParam("id") Integer userId,  Model model) {
		//int userId = Integer.parseInt(request.getParameter("id"));
		customers user = this.customerService.getCustomerByid(userId);
		if (user==null) {
			model.addAttribute("user","用户不存在");
			return "showUser";
		}
		model.addAttribute("user", user.getName());
		return "showUser";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/showUser1",method=RequestMethod.GET)
	public customers toIndex2( Model model) {

		int userId = Integer.parseInt(request.getParameter("id"));
		customers user = this.customerService.getCustomerByid(userId);
		if (user==null) {
			model.addAttribute("user","用户不存在");
			return null;
		}
		model.addAttribute("user", user.getName());
		return user;
	}

	@RequestMapping("/deleteUser")
	public void toDeleteById( Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		 this.customerService.deleteByid(userId);
	}
	
	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public ModelAndView  toDemo(){
		ModelAndView modelAndView=new ModelAndView("test/demo");
		Map<String, Object> modelMap=new HashMap<String, Object>();
		modelMap.put("yechao", "right");
		//modelAndView.addObject("yechao", "test");
		modelAndView.addAllObjects(modelMap);
		
		return modelAndView;
		
	}

}
