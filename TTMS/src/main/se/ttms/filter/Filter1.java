package main.se.ttms.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by dongmengyuan on 17-11-22.
 */

@WebFilter({"/employee.jsp"})
public class Filter1 implements Filter {



        public void destroy()
        {
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException
        {
            HttpServletRequest req = (HttpServletRequest) request;
            String flag = (String) req.getSession().getAttribute("Administrators");
            if (flag == null || !flag.equals("ok"))
            {
                request.setAttribute("desc", "无权访问管理员页面");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
            else {

                chain.doFilter(request, response);
//                request.getRequestDispatcher("/studio..jsp").forward(request, response);
            }
        }

        public void init(FilterConfig fConfig) throws ServletException
        {
        }

    }

