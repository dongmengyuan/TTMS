package main.se.ttms.service;


import main.se.ttms.dao.SeatDao;
import main.se.ttms.dao.SeatDaoImpl;

public class SeatServiceImpl implements SeatService {

	@Override
	public void updateSeat(String[] split) throws Exception {
		SeatDao dao = new SeatDaoImpl();
		for (String string : split) {
			dao.updateSeat(Integer.parseInt(string));
		}
	}
	
}
