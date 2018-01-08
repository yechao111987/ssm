package yechao.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;



@Controller
public class IndexController {
	
	
	@Resource
	private HttpServletRequest httpRequest;


	private final static Logger log=Logger.getLogger(IndexController.class);

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
		log.error(uri);
		ModelAndView modelAndView = new ModelAndView("index");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("URI", uri);// 注意大小写，小写无效的
		modelAndView.addAllObjects(modelMap);
		return modelAndView;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView toDemo() {
		ModelAndView modelAndView = new ModelAndView("test/demo");
		// modelAndView.addObject("yechao", "test");
		return modelAndView;

	}

}
