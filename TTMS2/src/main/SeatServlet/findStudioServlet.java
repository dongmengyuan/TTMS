package main.SeatServlet;

import com.google.gson.Gson;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findStudioServlet")
public class findStudioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println(request.getSession().getAttribute("user"));
        StudioService studioService = new StudioServiceImpl();


        List<Studio> list = null;
        try {
            list = studioService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = new Gson().toJson(list);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.append(s);
    }
}
