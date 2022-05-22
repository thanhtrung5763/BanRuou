package vn.liquor.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.OrderDao;
import vn.liquor.model.OrderModel;
import vn.liquor.util.SingletonServiceUtils;

public class OrderDaoImpl implements OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<OrderModel> getorderbysid(int sid) {
		String sql = "Select Cartdetail.id,Product.productId,bill.CartId from Cartdetail inner join Product on Cartdetail.productId = Product.productId inner join bill on Cartdetail.cartId=bill.CartId\r\n"
				+ "where Product.sellerId=?";
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderModel(SingletonServiceUtils.getCartItemDaoImpl().getbycitemid(rs.getInt(1)),
						SingletonServiceUtils.getProductDaoImpl().getproductbypid(rs.getInt(2)), SingletonServiceUtils.getBillDaoImpl().getbillbycaid(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<OrderModel> getorderbyuid(int uid) {
		String sql = "Select Cartdetail.id,Product.productId,bill.CartId from Cartdetail inner join Product on Cartdetail.productId = Product.productId inner join bill on Cartdetail.cartId=bill.CartId inner join Cart on cart.cartId=Cartdetail.cartId\r\n"
				+ "where Cart.userId=?";
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderModel(SingletonServiceUtils.getCartItemDaoImpl().getbycitemid(rs.getInt(1)),
						SingletonServiceUtils.getProductDaoImpl().getproductbypid(rs.getInt(2)), SingletonServiceUtils.getBillDaoImpl().getbillbycaid(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
