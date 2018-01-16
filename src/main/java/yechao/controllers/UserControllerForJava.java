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
import yechao.model.User;
import yechao.service.UserService;

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
    public Response<Boolean> getInfo(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        Response<Boolean> response = new Response<Boolean>();
        response = this.userService.loginByNameAndPassword(name, password);
        log.error(response.getMessage() + ";" + response.getCode());
//        if (response.getCode().equalsIgnoreCase("0")) {
//            ModelAndView modelAndView = new ModelAndView("jsp/demo.jsp");
//            return response;
//        }
//        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, httpServletResponse);
//        httpServletResponse.sendRedirect("/demo");
        return response;
    }

    @RequestMapping("loginTest")
    public void logintest(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        Response<Boolean> response = new Response<Boolean>();
        response = this.userService.loginByNameAndPassword(name, password);
        log.error(response.getMessage() + ";" + response.getCode());
        if (response.getCode().equalsIgnoreCase("0")) {
            Cookie cookie = new Cookie(name, password);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(5000);
            httpServletResponse.addCookie(cookie);
//            httpServletResponse.sendRedirect("/demo");
//            request.getSession().setAttribute();
            HttpSession session=request.getSession();
            String ss=session.getId();
            session.setAttribute("loginName", ss);
            request.getRequestDispatcher("/WEB-INF/jsp/showUser.jsp").forward(request, httpServletResponse);

        }
    }
}
