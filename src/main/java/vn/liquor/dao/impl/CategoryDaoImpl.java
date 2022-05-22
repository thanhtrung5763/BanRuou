package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.CategoryDao;
import vn.liquor.model.CategoryModel;

public class CategoryDaoImpl implements CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModel> get6cate() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "SELECT top 6* FROM Category order by CategoryID ASC";

		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả results
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<CategoryModel> getallCate() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "Select * from Category";

		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả results
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public int CountAllCate() {
		String query = "select Count(*) from dbo.Category";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public void insert(CategoryModel cate) {
		String sql = "INSERT INTO dbo.Category (categoryName,icons) VALUES (?,?)";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCname());
			ps.setString(2, cate.getIcons());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public CategoryModel getCate(int cid) {
		String sql = "Select * FROM dbo.Category WHERE CategoryID =?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			// Lấy ResultSet
			while (rs.next()) {
				return (new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void edit(CategoryModel cate) {
		String sql = "update dbo.Category set categoryName = ?, icons = ? where categoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCname());
			ps.setString(2, cate.getIcons());
			ps.setInt(3, cate.getCateid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int cid) {
		String sql = "delete from Category where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
