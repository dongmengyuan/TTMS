package main.SeatServlet;

import com.google.gson.Gson;
import main.se.ttms.model.User;
import main.se.ttms.service.SeatService;
import main.se.ttms.service.SeatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateSeatServlet")
public class updateSeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getType()==0){
            String msg = "您无权操作";
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            String json = new Gson().toJson(msg);
            PrintWriter writer = response.getWriter();
            writer.append(json);
            return;
        }

        String ids = request.getParameter("ids");
        String[] split = ids.split("-");
//		List<Integer> ids1 = new ArrayList<>();
//		for (String string : split) {
//
//		}

        SeatService seatService = new SeatServiceImpl();

        try {
            seatService.updateSeat(split);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
