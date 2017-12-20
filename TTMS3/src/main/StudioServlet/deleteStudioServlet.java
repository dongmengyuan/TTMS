package main.StudioServlet;

import main.se.ttms.service.StudioService;
import main.se.ttms.service.StudioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudioServlet")
public class deleteStudioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StudioService studioService = new StudioServiceImpl();
        try {
            studioService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
