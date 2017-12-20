package main.se.ttms.dao;

import main.se.ttms.model.Seat;
import main.se.ttms.model.Studio;

import java.util.List;


public interface StudioDao {
	public List<Studio> findStudioList() throws Exception;
	
	public Studio getById(Integer id) throws Exception;
	
	public void deleteById(Integer id) throws Exception;
	
	public void updateStudio(Studio studio) throws Exception;

	public void insert(Studio studio) throws Exception;

	public List<Seat> findSeatById(int id) throws Exception;
}
