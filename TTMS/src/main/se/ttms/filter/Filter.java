package main.se.ttms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dongmengyuan on 17-11-20.
 */

@WebFilter("/*")

public class Filter implements javax.servlet.Filter {
    private static ArrayList<String> list = new ArrayList<String>();

    static {
        list.add("/index.jsp");
        list.add("/Login");
        list.add("/view/system_manager/Bootstrap/bs.css");
        list.add("/view/system_manager/css/login.css");
        list.add("/view/system_manager/image/sky.jpg");
    }


    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        String path = ((HttpServletRequest) request).getServletPath();

        if (list.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        String state = (String) req.getSession().getAttribute("login");
        if (state != null && state.equals("ok")) {
            chain.doFilter(request, response);
            return;
        } else {
            System.out.println(path + "   filter resource");
            rep.sendRedirect("/index.jsp");
        }
    }

    public void destroy() {
    }


}
