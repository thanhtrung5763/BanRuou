package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.CityDao;
import vn.liquor.model.CityModel;
import java.sql.Connection;

public class CityDaoImpl implements CityDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insertcity(CityModel city) {
		String sql = "Insert into ship(shipid,cityname,shipprice) values(?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, city.getShipid());
			ps.setString(2, city.getCityname());
			ps.setInt(3, city.getShipprice());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void updatecity(CityModel city) {
		String sql = "Update ship set cityname=?,shipprice=? where shipid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, city.getCityname());
			ps.setInt(2, city.getShipprice());
			ps.setInt(3, city.getShipid());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delcity(int id) {
		String sql = "Delete from ship where shipid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<CityModel> getallcity() {
		List<CityModel> list = new ArrayList<CityModel>();
		String sql = "Select * from ship order by cityname asc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CityModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public CityModel getcitybyid(int id) {
		String sql = "Select * from ship where shipid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new CityModel(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
