package yechao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import yechao.UserService;
import yechao.UserServiceImpl;
import yechao.model.User;

public class IndexController {

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String toIndex(Model model) {
		return "index";
	}

}
