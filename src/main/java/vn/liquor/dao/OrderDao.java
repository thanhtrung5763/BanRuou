package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.OrderModel;

public interface OrderDao {
	public List<OrderModel> getorderbysid(int sid);

	public List<OrderModel> getorderbyuid(int uid);
}
