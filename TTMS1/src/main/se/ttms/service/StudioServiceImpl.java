package main.se.ttms.service;

import main.se.ttms.dao.SeatDao;
import main.se.ttms.dao.SeatDaoImpl;
import main.se.ttms.dao.StudioDao;
import main.se.ttms.dao.StudioDaoImpl;
import main.se.ttms.model.Seat;
import main.se.ttms.model.Studio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class StudioServiceImpl implements StudioService{

	@Override
	public List<Studio> findAll() throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		return studioDao.findStudioList();
	}

	@Override
	public Studio getById(Integer id) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		return studioDao.getById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		SeatDao seatDao = new SeatDaoImpl();
		seatDao.delete(id);
		studioDao.deleteById(id);
	}

	@Override
	public void updateStudio(Studio studio) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		studioDao.updateStudio(studio);
	}

	@Override
	public void insert(Studio studio) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		String id = studioDao.insert(studio);
		
		SeatDao seatDao = new SeatDaoImpl();
		Seat seat  ;
		List<Seat> seatList = new ArrayList<Seat>();
		for (int i = 0; i < studio.getStudio_row_count(); i++){ 
			for (int j = 0; j < studio.getStudio_col_count(); j++){
				seat=new Seat();
				seat.setStudio_id(Integer.parseInt(id));
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
	public List<Seat> findSeatById(int id) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		return studioDao.findSeatById(id);
	}

}
