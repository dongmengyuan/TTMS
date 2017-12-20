package main.SeatServlet;

import com.google.gson.Gson;
import main.se.ttms.service.SeatService;
import main.se.ttms.service.SeatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addSeatServlet")
public class addSeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int row = Integer.parseInt(request.getParameter("row"));
        int col = Integer.parseInt(request.getParameter("col"));

        SeatService seatService = new SeatServiceImpl();
        String msg = "";
        try {
            int seatCount = seatService.SeatisExist(id);

            if(seatCount==0){
                seatService.addSeraServlet(id,row,col);
                msg = "添加座位成功!!!";
            }else{
                msg = "该演出厅已存在座位!!!";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String json = new Gson().toJson(msg);
        PrintWriter writer = response.getWriter();
        writer.append(json);
    }
}
