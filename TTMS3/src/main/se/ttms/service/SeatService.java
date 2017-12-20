package main.se.ttms.service;

public interface SeatService {

	public void updateSeat(String[] split) throws Exception;

	public void addSeraServlet(int id,int row,int col) throws  Exception;

    public int SeatisExist(int id) throws Exception;
}
