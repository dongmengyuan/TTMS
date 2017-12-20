package main.se.ttms.dao;


import main.se.ttms.model.Seat;

public interface SeatDao {
	public void insert(Seat seat) throws Exception;
	public void delete(int id) throws Exception;
	public void updateSeat(int parseInt) throws Exception;

    public int SeatisExist(int id) throws Exception;
}
