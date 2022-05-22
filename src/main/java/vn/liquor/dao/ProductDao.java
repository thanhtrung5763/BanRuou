package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.CartItemModel;
import vn.liquor.model.ProductModel;

public interface ProductDao {
	ProductModel getproduct(String pid);

	List<ProductModel> SearchByProductName(String txtSearch);

	int CountProduct();

	List<ProductModel> gettop1product();

	List<ProductModel> getnew8product();

	List<ProductModel> getallproduct();

	List<ProductModel> getallproductbycID(String cid);

	void insertProduct(ProductModel productModel);

	void updateProduct(ProductModel productModel);

	void deleteProduct(int pid);

	ProductModel getproductbypid(int pid);

	List<ProductModel> getallproductbySid(int sid);

	List<ProductModel> pagingProduct(int index);

	List<ProductModel> pagingProductByCID(int index, String cid);

	int countProductByCID(String cid);

	List<ProductModel> getProductByUseridSeller(String sellerid);

	List<CartItemModel> ThongkeSLSanDaBan(String id);

	List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id, String date);

	void insertamount(int pid, String caid);

	void insertsellamount(int pid, String caid);

	void updateamount(int pid, String caid);
}
