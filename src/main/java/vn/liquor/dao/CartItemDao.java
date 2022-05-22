package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.CartItemModel;

public interface CartItemDao {

	void insert(CartItemModel cartItem);

	void edit(CartItemModel cartItem);

	void delete(String id);

	CartItemModel get(String name);

	CartItemModel get(int id);

	List<CartItemModel> getAll();

	List<CartItemModel> search(String name);

	CartItemModel getbycitemid(int id);

	List<CartItemModel> getAllCartItem(String id);

	void accept(int cid);

	void deny(int cid);
}
