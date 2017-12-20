package main.se.ttms.service;


import main.se.ttms.dao.SeatDao;
import main.se.ttms.dao.SeatDaoImpl;
import main.se.ttms.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatServiceImpl implements SeatService {

	@Override
	public void updateSeat(String[] split) throws Exception {
		SeatDao dao = new SeatDaoImpl();
		for (String string : split) {
			dao.updateSeat(Integer.parseInt(string));
		}
	}

	@Override
	public void addSeraServlet(int id, int row, int col) throws Exception {
		SeatDao seatDao = new SeatDaoImpl();
		Seat seat  ;
		List<Seat> seatList = new ArrayList<Seat>();
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				seat=new Seat();
				seat.setStudio_id(id);
				seat.setSeat_row(i+1);
				seat.setSeat_column(j+1);
				seat.setSeat_status(1);
				seatList.add(seat);
			}
		}

		for (Seat seat2 : seatList) {
			seatDao.insert(seat2);
		}
	}

	@Override
	public int SeatisExist(int id) throws Exception {
		SeatDao seatDao = new SeatDaoImpl();
		return seatDao.SeatisExist(id);
	}

}
