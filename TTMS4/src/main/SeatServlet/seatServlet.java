package main.SeatServlet;

import com.google.gson.Gson;
import main.se.ttms.model.Seat;
import main.se.ttms.model.Studio;
import main.se.ttms.service.StudioService;
import main.se.ttms.service.StudioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/seatServlet")
public class seatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudioService service = new StudioServiceImpl();
        try {
            List<Seat> list = service.findSeatById(id);
            Studio studio = service.getById(id);
            Gson gson = new Gson();
            String json = gson.toJson(list);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            request.setAttribute("studio", studio);
            request.setAttribute("seat", json);
            request.getRequestDispatcher("/seat.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
