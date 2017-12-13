package main.StudioServlet;

import main.se.ttms.model.Studio;
import main.se.ttms.model.User;
import main.se.ttms.service.StudioService;
import main.se.ttms.service.StudioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudioAllServlet")
public class findStudioAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getType()==0){
            request.setAttribute("msg", "您无权访问");
            request.getRequestDispatcher("/error1.jsp").forward(request, response);
        }
        //System.out.println(request.getSession().getAttribute("user"));
        StudioService studioService = new StudioServiceImpl();


        List<Studio> list = null;
        try {
            list = studioService.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("studioList", list);
//			response.sendRedirect(request.getContextPath()+"/findStudioAllServlet");
        request.getRequestDispatcher("/studio.jsp").forward(request, response);
    }
}
