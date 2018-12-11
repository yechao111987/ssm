package yechao.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import scala.CustomerFormScala;
import yechao.basic.PageForm;
import yechao.basic.Response;
import yechao.manage.CustomerManage;
import yechao.model.Customer;
import yechao.service.CustomerService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import yechao.yechaoUtil.StringUtil;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final static String INFO = "yechao";

    @Resource
    private CustomerService customerService;
    @Resource
    private HttpServletRequest request;
    // @Resource
    // private Response<Customers> response;
    @Resource
    private CustomerManage customerManage;

    private final static Logger log = Logger.getLogger(CustomerController.class);

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageForm toList(@RequestParam("current") Integer currentPage, @RequestParam("size") Integer size) {
        PageForm pageForm = new PageForm();
        pageForm = customerService.listByPage(currentPage, size);
        log.info(currentPage);
        log.info(size);
        log.error(JSON.toJSONString(pageForm));
        return pageForm;

    }

    @RequestMapping(value = "/list2", method = RequestMethod.GET)
    public String toTest() {
        ModelAndView modelAndView = new ModelAndView("test/list");
        Map<String, Object> modelMap = new HashMap<String, Object>();
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
    @RequestMapping(value = "/showCustomer", method = RequestMethod.GET)
    public Response<Customer> toIndex2(Model model) {
        Response<Customer> response = new Response<Customer>();
        String aa = request.getParameter("id");
        if (null == request.getParameter("id") || request.getParameter("id") == "" || !StringUtil.isNumberic(request.getParameter("id"))) {
            response.setCode("1");
            response.setMessage("id为空或者id非数字");
            return response;
        }
        int userId = Integer.parseInt(request.getParameter("id"));
        response = this.customerService.getCustomerByid(userId);
        if (response.getCode().equals("0") && response.getDataResult() != null) {
            return response;
        }
        log.info(JSON.toJSONString(response));
        return response;
    }

    @RequestMapping("/deleteCustoner")
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
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public Customer toAddCustomer(Model model) {
        Customer customer = new Customer();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        // String id=request.getParameter("id");
        customer.setName(name);
        customer.setPhone(phone);
        customer.setAddress(address);
        // customerVo.setId(Integer.valueOf(id));
        this.customerService.insertUser(customer);
        return customer;
    }

    @ResponseBody
    @RequestMapping(value = "/addCustomerByPost", method = RequestMethod.POST)
    public Response<Customer> toAddCustomerByPost() {
        Response<Customer> response = new Response<>();
        String info = null;
        try {
            info = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.error(info);
        Map<String, Object> map = new HashMap<>();
        CustomerFormScala customerFormScala = JSON.parseObject(info, CustomerFormScala.class);
        Customer customer = new Customer();
        if (null == customer) {
            response.setCode("1");
            response.setMessage("参数不正确");
            return response;
        }
        String aesinfo = DigestUtils.sha1Hex(info);
        log.error(aesinfo);
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
        // String id=request.getParameter("id");
        String name = "1";
        String phone = "11";
        String address = "111";
        customer.setName(customerFormScala.getName());
        customer.setPhone(customerFormScala.getPhone());
        customer.setAddress(customerFormScala.getAddress());
        // customerVo.setId(Integer.valueOf(id));
        this.customerService.insertUser(customer);
        response.setCode("0");
        response.setMessage("新增成功");
        response.setDataResult(customer);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/addCustomerByManage", method = RequestMethod.GET)
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


    @RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
    @ResponseBody
    public Response<Boolean> toUpdateCustomer(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        Response<Boolean> response = new Response<>();
        Customer customer = new Customer();
        System.out.println("yechao");
        customer.setId(id);
        customer.setAddress(address);
        customer.setName(name);
        customer.setPhone(phone);
        System.out.println("yechao1");
        System.out.println("yechao1_1");
        log.info(customer.getId());
        if (customerService.updateCustomer(customer)) {
            response.setCode("0");
//            response.setMessage("更新成功");
        } else {
            response.setCode("1");
            response.setMessage("更新失败");
            response.setDataResult(false);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Response<Boolean> toDelCustomer(@RequestParam("id") Integer id) {
        Response<Boolean> response = new Response<>();
        try {
            customerService.deleteByid(id.intValue());
            response.setCode("0");
            response.setDataResult(true);
            response.setMessage("删除客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("1");
            response.setMessage("删除失败");
            response.setDataResult(false);
        }
        return response;

    }


}
