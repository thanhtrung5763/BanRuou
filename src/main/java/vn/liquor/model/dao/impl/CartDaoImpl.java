package vn.liquor.model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.CartDao;
import vn.liquor.model.CartModel;
import vn.liquor.util.SingletonServiceUtils;

public class CartDaoImpl extends DBConnect implements CartDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Cart(Cartid,userid, datecreate,totalprice) VALUES (?,?,?,?)";

		try {
			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart.getId());
			ps.setInt(2, cart.getBuyer().getUid());
			ps.setDate(3, new Date(cart.getBuyDate().getTime()));
			ps.setInt(4, cart.getTotal());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartModel cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartModel get(String id) {
		String sql = "Select * from Cart where Cartid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next())
				return new CartModel(rs.getString(1), SingletonServiceUtils.getUserDaoImpl().get(rs.getInt(2)), rs.getDate(3), rs.getInt(4));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<CartModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartModel getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartModel> getAllCart() {
		List<CartModel> listcart = new ArrayList<CartModel>();
		String sql = "Select * from Cart";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getString(1));
				cart.setBuyer(SingletonServiceUtils.getUserDaoImpl().get(rs.getInt(2)));
				cart.setBuyDate(rs.getDate(3));
				cart.setTotal(rs.getInt(4));
				listcart.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcart;
	}

	@Override
	public CartModel getCart(String id) {
		String sql = "Select * from Cart where cartId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getString(1));
				cart.setBuyer(SingletonServiceUtils.getUserDaoImpl().get(rs.getInt(2)));
				cart.setBuyDate(rs.getDate(3));
				cart.setTotal(rs.getInt(4));

				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<CartModel> getcartbyuid(int uid) {
		String sql = "Select * from Cart where userid=?";
		List<CartModel> list = new ArrayList<CartModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next())
				list.add(new CartModel(rs.getString(1), SingletonServiceUtils.getUserDaoImpl().get(rs.getInt(2)), rs.getDate(3), rs.getInt(4)));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
