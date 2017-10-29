package yechao.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {
	
	
	@Resource
	private HttpServletRequest httpRequest;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index(Model model) {
		String uri=httpRequest.getRequestURI();
		System.out.println("URI:"+uri);
		model.addAttribute("URI", uri);
		return "index";
	}
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView toIndex() {
		String uri=httpRequest.getRequestURI();
		System.out.println("1111"+uri);
		ModelAndView modelAndView=new ModelAndView("index");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("uri", uri);
		return modelAndView;
	}

}
