package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.CartItemDao;
import vn.liquor.model.CartItemModel;
import vn.liquor.model.CartModel;
import vn.liquor.model.ProductModel;

import vn.liquor.util.SingletonServiceUtils;

public class CartItemDaoImpl implements CartItemDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "insert into Cartdetail(cartId,productId,unitprice,quantity,subtotal,status) values(?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cartItem.getCartid().getId());
			ps.setInt(2, cartItem.getProduct().getProductId());
			ps.setInt(3, cartItem.getUnitPrice());
			ps.setInt(4, cartItem.getQuantity());
			ps.setInt(5, cartItem.getSubtotal());
			ps.setInt(6, cartItem.getStatus());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void edit(CartItemModel cartItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartItemModel get(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from cartdetail where cartid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
				return new CartItemModel(rs.getInt(1), SingletonServiceUtils.getCartDaoImpl().get(rs.getString(2)),
						SingletonServiceUtils.getProductDaoImpl().getproductbypid(rs.getInt(3)), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<CartItemModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel getbycitemid(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from cartdetail where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
				return new CartItemModel(rs.getInt(1), SingletonServiceUtils.getCartDaoImpl().get(rs.getString(2)),
						SingletonServiceUtils.getProductDaoImpl().getproductbypid(rs.getInt(3)), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public CartItemModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> getAllCartItem(String id) {
		List<CartItemModel> listcartitem = new ArrayList<CartItemModel>();
		String sql = "Select * from Cartdetail where cartId=? and status=1";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = SingletonServiceUtils.getCartDaoImpl().getCart(rs.getString(2));
				ProductModel product = SingletonServiceUtils.getProductDaoImpl().getproductbypid(rs.getInt(3));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setQuantity(rs.getInt(5));
				cartItem.setUnitPrice(rs.getInt(4));
				cartItem.setProduct(product);
				cartItem.setCartid(cart);
				listcartitem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcartitem;
	}

	@Override
	public void accept(int cid) {
		String sql = "Update Cartdetail set status=1 where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	@Override
	public void deny(int cid) {
		String sql = "Update Cartdetail set status=-1 where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
