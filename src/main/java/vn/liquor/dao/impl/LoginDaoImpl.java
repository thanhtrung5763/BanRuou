package vn.liquor.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.LoginDao;
import vn.liquor.model.AccountModel;

public class LoginDaoImpl implements LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public AccountModel login(String user, String pass) {
		String sql = "select * from Users where userName=? and Password=? and status=0";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				return new AccountModel( rs.getInt(1), 
						rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5),rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
