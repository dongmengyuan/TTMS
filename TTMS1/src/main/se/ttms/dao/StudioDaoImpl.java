package main.se.ttms.dao;

import java.math.BigInteger;
import java.util.List;

import main.se.ttms.model.Seat;
import main.se.ttms.model.Studio;
import main.se.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



public class StudioDaoImpl implements StudioDao {

	@Override
	public List<Studio> findStudioList() throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from studio";
		return qr.query(sql, new BeanListHandler<>(Studio.class));
	}

	@Override
	public Studio getById(Integer id) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from studio where studio_id = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Studio.class),id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="delete from studio where studio_id = ? ";
		qr.update(sql, id);
	}

	@Override
	public void updateStudio(Studio studio) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="update studio set studio_name = ?,studio_row_count = ?,studio_col_count = ?,"
				+ "studio_introduction = ?,studio_flag = ? where studio_id = ?";
		qr.update(sql, studio.getStudio_name(),studio.getStudio_row_count(),studio.getStudio_col_count(),
				studio.getStudio_introduction(),studio.getStudio_flag(),studio.getStudio_id());
	}

	@Override
	public String insert(Studio studio) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());

		String sql="insert into studio(studio_name,studio_row_count,studio_col_count,"
				+ "studio_introduction,studio_flag) values(?,?,?,?,?)";

		qr.update(sql,studio.getStudio_name(),studio.getStudio_row_count(),studio.getStudio_col_count(),
				studio.getStudio_introduction(),studio.getStudio_flag());

		sql = "SELECT LAST_INSERT_ID()";

		Object query = qr.query(sql, new ScalarHandler());


		return query.toString();
	}

	@Override
	public List<Seat> findSeatById(int id) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql ="select * from seat where studio_id = ?";
		
		
		return qr.query(sql, new BeanListHandler<>(Seat.class),id);
	}

	

	

}
