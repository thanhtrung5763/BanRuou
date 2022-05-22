package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.UserDao;
import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(AccountModel user) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountModel get(int id) {
		String sql = "SELECT * FROM Users WHERE UserId = ?";

		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setUid(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("Password"));
				user.setIsSeller(rs.getInt("isSeller"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setStatus(rs.getInt("status"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countAllAccount() {
		String query = "SELECT count(*)\r\n" + "  FROM dbo.Users";
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
	public AccountDetailModel layaccountdetail(int id) {
		// Khai báo chuỗi truy vấn
		String sql = "select * from dbo.Userinfo\r\n" + "where userid = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountDetailModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void editdetail(AccountDetailModel user) {
		String sql = "UPDATE dbo.Userinfo SET fullName=?, CMND=?, phoneNumber=?, fullAddress=?, imageLink=? WHERE userId = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getCmnd());
			ps.setString(3, user.getSdt());
			ps.setString(4, user.getDiachi());
			ps.setString(5, user.getImageLink());
			ps.setInt(6, user.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editdetailimage(AccountDetailModel user) {
		String sql = "UPDATE dbo.Userinfo SET imageLink=? WHERE userId = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getImageLink());
			ps.setInt(2, user.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<AccountModel> getalluser() {
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "Select * from dbo.Users";

		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả results
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public void ban(int id) {
		String sql = "update dbo.Users set status = 1 where userid = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void unban(int id) {
		String sql = "update dbo.Users set status = 0 where userid = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "Delete from dbo.Users where userid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (Exception e) {

		}

	}

	@Override
	public void register(AccountModel acc) {
		String sql = "Insert into Users(userName,[Password],isSeller,isAdmin,[status]) values(?,?,?,?,?)  ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, acc.getUsername());
			ps.setString(2, acc.getPassword());
			ps.setInt(3, acc.getIsSeller());
			ps.setInt(4, acc.getIsAdmin());
			ps.setInt(5, acc.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public AccountModel checkuser(String username) {
		String sql = "Select * from [Users] where [userName]=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next())
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6));
		} catch (Exception e) {
		}

		return null;
	}

	@Override
	public void adddetail(AccountDetailModel user) {
		String sql = "INSERT INTO dbo.Userinfo (userId, fullName, CMND, phoneNumber, fullAddress, imageLink) VALUES (?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUid());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getCmnd());
			ps.setString(4, user.getSdt());
			ps.setString(5, user.getDiachi());
			ps.setString(6, user.getImageLink());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletedetail(int id) {
		String sql = "Delete from dbo.Userinfo where userId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (Exception e) {

		}

	}

	@Override
	public List<AccountDetailModel> getalluserdetail() {
		List<AccountDetailModel> list = new ArrayList<AccountDetailModel>();
		String sql = "Select * from dbo.Userinfo";

		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả results
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AccountDetailModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}
}
