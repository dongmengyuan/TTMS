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
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("进入过滤器FilterA");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String flag = (String) req.getSession().getAttribute("a");

        String path = ((HttpServletRequest) request).getServletPath();

//        if (flag == null || !flag.equals("ok")) {
//            System.out.println("无权访问a路径");
//            request.setAttribute("desc", "无权访问a路径");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//        }

            System.out.println(path+"    ds");
        ArrayList<String> list = new ArrayList<String>() {
            {
                add("/index1.jsp");
                add("/index.jsp");
                add("/Login");
            }

        };

        if (list.contains(path)) {
            chain.doFilter(request, response);
            return ;
        }
        String state = (String)((HttpServletRequest) request).getSession().getAttribute("login");
        if(state !=null && state.equals("ok")) {
            chain.doFilter(request, response);
            return ;
        }else{
            rep.sendRedirect("/index1.jsp");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
