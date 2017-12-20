package main.se.ttms.dao;

import main.se.ttms.model.Seat;
import main.se.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


public class SeatDaoImpl implements SeatDao {

	@Override
	public void insert(Seat seat) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into seat(studio_id,seat_row,seat_column,seat_status) values(?,?,?,?)";
		System.out.println(seat.toString());
		qr.update(sql,seat.getStudio_id(),seat.getSeat_row(),seat.getSeat_column(),seat.getSeat_status());
	}

	@Override
	public void delete(int id) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "delete from seat where studio_id = ?";
		qr.update(sql,id);
	}

	@Override
	public void updateSeat(int parseInt) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update seat set seat_status = ? where seat_id = ?";
		
		qr.update(sql,0,parseInt);
	}

	@Override
	public int SeatisExist(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select count(*) from seat where studio_id = ?";

		return ((Long)qr.query(sql,new ScalarHandler(),id)).intValue();
	}

}
