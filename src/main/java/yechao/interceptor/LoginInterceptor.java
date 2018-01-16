package yechao.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.JavaNetHttpCookieAccess;
import yechao.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的URL
        String url = httpServletRequest.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if (url.indexOf("login.jsp") >= 0) {
            return true;
        }
        //获取Session
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("mysession");

        if (username != null) {
            return true;
        }

        //获取Cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        String uname = null, upassword = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equalsIgnoreCase("uname")) {
                uname = cookies[i].getValue();
            } else if (cookies[i].getName().equalsIgnoreCase("upassword")) {
                upassword = cookies[i].getValue();
            }
        }
        if (null != userService.loginByNameAndPassword(uname, upassword) && userService.loginByNameAndPassword(uname, upassword).getCode().equalsIgnoreCase("0")) {
            return true;
        }


        //不符合条件的，跳转到登录界面
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
