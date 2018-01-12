package yechao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import scala.UserScala;
import yechao.basic.Response;
import yechao.model.User;
import yechao.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserControllerForJava {
    @Autowired
    private UserService userService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping("getInfoForJava")
    @ResponseBody
    public Response<UserScala> getInfo(@RequestParam("id") Integer id){
//        Integer id=request.getParameter("id");
        Response<UserScala> response=new Response<>();
        response=this.userService.getUserInfoById(id);
        return response;
    }
}
