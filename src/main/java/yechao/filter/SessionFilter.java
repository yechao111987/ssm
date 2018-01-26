package yechao.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class SessionFilter implements Filter {

    private FilterConfig config;

    private final static Logger log = Logger.getLogger(SessionFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);

        String logonStrings = config.getInitParameter("logonStrings");        // 登录登陆页面
        String includeStrings = config.getInitParameter("includeStrings");    // 过滤资源后缀参数
        String notInclideStrings = config.getInitParameter("notIncludeStrings");
        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");// 没有登陆转向页面
        String disabletestfilter = config.getInitParameter("disabletestfilter");// 过滤器是否有效

        if (disabletestfilter.toUpperCase().equals("Y")) {    // 过滤无效
            filterChain.doFilter(servletRequest, servletResponse);
            log.error("diablefilter:Y");
            return;
        }

        String[] logonList = logonStrings.split(";");
        String[] includeList = includeStrings.split(";");
        String[] notInclideList = notInclideStrings.split(";");

        if (this.isContains(hrequest.getRequestURI(), notInclideList)) {// 对指定过滤参数后缀如css,js，直接放过
            log.info("不过滤的uri：" + hrequest.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


//        if (!this.isContains(hrequest.getRequestURI(), includeList)) {// 只对指定过滤参数后缀进行过滤
//            filterChain.doFilter(servletRequest, servletResponse);
//            log.info("只对指定过滤参数后缀进行过滤:"+hrequest.getRequestURI());
//            return;
//        }

        if (this.isContains(hrequest.getRequestURI(), logonList)) {// 对登录页面不进行过滤
            log.info("对登录页面不进行过滤:" + hrequest.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String user = (String) hrequest.getSession().getAttribute("loginName");//判断用户是否登录
        log.info(user);
        if (user == null) {
            log.info(redirectPath);
            //若用户登录session不存在，则跳转到登录页面
            wrapper.sendRedirect(redirectPath);
            log.error("用户session不存在，redirect：" + redirectPath);
            return;
        } else {
            log.info("用户已经登录");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        this.config = null;
    }

    public static boolean isContains(String container, String[] regx) {
        boolean result = false;

        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }
}
