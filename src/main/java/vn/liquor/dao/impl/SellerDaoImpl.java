package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.SellerDao;
import vn.liquor.model.SellerInfoModel;
import vn.liquor.model.SellerModel;

public class SellerDaoImpl implements SellerDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void registerseller(SellerModel seller) {
		String sql = "Insert into seller(uid,shopName,email,phone) values(?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seller.getUid());
			ps.setString(2, seller.getShopName());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPhone());
			ps.executeQuery();
		} catch (Exception e) {
		}
	}

	@Override
	public void registerinfo(SellerInfoModel sellerinfo) {
		String sql = "Insert into sellerinfo(sellerId,province,district,fulladdress) values(?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerinfo.getSellerId());
			ps.setString(2, sellerinfo.getProvince());
			ps.setString(3, sellerinfo.getDistrict());
			ps.setString(4, sellerinfo.getFullAddress());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public SellerModel checkshopname(String shopname) {
		String sql = "Select * from seller where shopname=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, shopname);
			rs = ps.executeQuery();
			while (rs.next())
				return new SellerModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public SellerModel getsellerbyuid(int uid) {
		String sql = "Select * from seller where uid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next())
				return new SellerModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void updateisseller(int uid) {
		String sql = "UPDATE dbo.Users SET isSeller='1' WHERE userId = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<SellerModel> getallseller() {
		List<SellerModel> list =new ArrayList<SellerModel>();
		String sql="select * from seller";
		try
		{
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
				list.add( new SellerModel(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}


}
