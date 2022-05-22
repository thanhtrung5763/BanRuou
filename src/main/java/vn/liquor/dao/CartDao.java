package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.CartModel;

public interface CartDao {

	void insert(CartModel cart);

	void edit(CartModel cart);

	void delete(int id);

	CartModel get(String name);

	CartModel get(int id);

	List<CartModel> getAll();

	List<CartModel> search(String name);

	public CartModel getCart();

	List<CartModel> getAllCart();

	CartModel getCart(String id);
	List<CartModel> getcartbyuid(int uid) ;
}
