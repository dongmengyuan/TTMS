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
		studioDao.insert(studio);
	}

	@Override
	public List<Seat> findSeatById(int id) throws Exception {
		StudioDao studioDao = new StudioDaoImpl();
		return studioDao.findSeatById(id);
	}

}
