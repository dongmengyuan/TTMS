package main.StudioServlet;

import main.se.ttms.model.Studio;
import main.se.ttms.service.StudioService;
import main.se.ttms.service.StudioServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudioServlet")
public class addStudioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudioService studioService = new StudioServiceImpl();
        Studio studio = new Studio();
        try {
            BeanUtils.populate(studio, request.getParameterMap());
                studioService.insert(studio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
