package yechao.controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import scala.UserScala;
import yechao.basic.Response;
import yechao.basic.StaticVar;
import yechao.model.User;
import yechao.service.UserService;
import yechao.yechaoUtil.AesEncode;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserControllerForJava {
    @Autowired
    private UserService userService;
    @Resource
    private HttpServletRequest request;
    final static Logger log = Logger.getLogger(UserControllerForJava.class);


    @RequestMapping("getInfoForJava")
    @ResponseBody
    public Response<UserScala> getInfo(@RequestParam("id") Integer id) {
//        Integer id=request.getParameter("id");
        Response<UserScala> response = new Response<>();
        response = this.userService.getUserInfoById(id);
        return response;
    }


    @RequestMapping("login")
    @ResponseBody
    public Response<Boolean> login(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        Response<Boolean> response = new Response<Boolean>();
        if (userService.loginByNameAndPassword(name, password)) {
            //写入cookie
            String content = name + password;
            String aesString = AesEncode.AESEncode(StaticVar.AESKEY, content);
            Cookie cookie = new Cookie("token", aesString);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(5000);
            httpServletResponse.addCookie(cookie);
            //设置session
            HttpSession session = request.getSession();
            String ssid = session.getId();
            session.setAttribute("loginName", ssid);
            response.setCode("0");
            response.setMessage("用户登录成功");
            response.setDataResult(true);
            return response;
        }
        response.setCode("1");
        response.setMessage("用户名或者密码错误");
        response.setDataResult(false);
        return response;
    }

    @RequestMapping("register")
    @ResponseBody
    public Response<Boolean> register(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        Response<Boolean> response = new Response<Boolean>();
        UserScala userScala = new UserScala();
        log.info(name);
        log.info(password);
        if (null == name || null == password) {
            response.setCode("1");
            response.setMessage("密码或者用户名为空");
            response.setDataResult(false);
            return response;
        }
        if (null != userService.getUserInfoByName(name)) {
            response.setCode("2");
            response.setMessage("用户名已结存在");
            response.setDataResult(false);
            return response;
        }
        userScala.setName(name);
        userScala.setPassword(password);
        if (null != request.getParameter("address")) {
            userScala.setAddress(request.getParameter("addresss"));

        }
        if (null != request.getParameter("phone")) {
            userScala.setAddress(request.getParameter("phone"));
        }
        if (userService.register(userScala)) {
            response.setCode("0");
            response.setMessage("用户注册成功");
            response.setDataResult(true);
            return response;
        } else {
            response.setCode("1");
            response.setMessage("用户注册失败");
            response.setDataResult(false);
            return response;
        }
    }

}
