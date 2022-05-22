package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.ProductDao;
import vn.liquor.model.AccountModel;
import vn.liquor.model.CartItemModel;
import vn.liquor.model.CartModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;

public class ProductDaoImpl implements ProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<ProductModel> gettop1product() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai bÃ¡o chuá»—i truy váº¥n
		String sql = "Select top 1* from Product\r\n" + "order by sellAmount Desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<ProductModel> getallproductbySid(int sid) {
		List<ProductModel> list = new ArrayList<ProductModel>();

		String sql = "Select * from Product\r\n" + "where sellerid=? order by price ASC";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<ProductModel> getnew8product() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai bÃ¡o chuá»—i truy váº¥n
		String sql = "Select top 8* from Product\r\n" + "order by ProductID Desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getallproduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai bÃ¡o chuá»—i truy váº¥n
		String sql = "Select * from Product\r\n" + "order by price ASC";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getallproductbycID(String cid) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai bÃ¡o chuá»—i truy váº¥n
		String sql = "Select * from Product\r\n" + "where categoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ProductModel getproduct(String pid) {
		String sql = " Select * from product \r\n" + " where ProductID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ProductModel> SearchByProductName(String txtSearch) {
		// Khai bao list de luu danh sach san pham
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai bao chuoi truy van
		String sql = "  select * from Product where productName like ?";
		try {
			// mo ket noi database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// gán giá trị cho từng dấu hỏi
			ps.setString(1, "%" + txtSearch + "%");
			// chạy query va nhan ve kq
			rs = ps.executeQuery();
			// lấy resultset đồ vào list
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	@Override
	public int CountProduct() {
		String query = "SELECT count(productId)\r\n" + "  FROM Product";
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
	public void insertProduct(ProductModel productModel) {
		String sql = "Insert into Product(productName,description,price,imageLink,categoryId,sellerId,sellamount,inventory,discount,status) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, productModel.getProductName());
			ps.setString(2, productModel.getDescription());
			ps.setInt(3, productModel.getPrice());
			ps.setString(4, productModel.getImageLink());
			ps.setInt(5, productModel.getCategoryId());
			ps.setInt(6, productModel.getSellerId());
			ps.setInt(7, productModel.getSellAmount());
			ps.setInt(8, productModel.getInventory());
			ps.setInt(9, productModel.getDiscount());
			ps.setInt(10, productModel.getStatus());
			ps.executeQuery();
		} catch (Exception e) {
		}
	}

	@Override
	public void updateProduct(ProductModel productModel) {
		String sql = "Update Product set productName=?,description=?,price=?,imageLink=?,categoryId=?,sellerId=?,sellamount=?,inventory=?,discount=?,status=? where productId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, productModel.getProductName());
			ps.setString(2, productModel.getDescription());
			ps.setInt(3, productModel.getPrice());
			ps.setString(4, productModel.getImageLink());
			ps.setInt(5, productModel.getCategoryId());
			ps.setInt(6, productModel.getSellerId());
			ps.setInt(7, productModel.getSellAmount());
			ps.setInt(8, productModel.getInventory());
			ps.setInt(9, productModel.getDiscount());
			ps.setInt(10, productModel.getStatus());
			ps.setInt(11, productModel.getProductId());
			ps.executeQuery();
		} catch (Exception e) {

		}

	}

	@Override
	public void deleteProduct(int pid) {
		String sql = "Delete from Product where productId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.executeQuery();
		} catch (Exception e) {

		}

	}

	@Override
	public ProductModel getproductbypid(int pid) {
		String sql = "select * from Product where productId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return (new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product order by ProductId OFFSET ? ROW fetch next 6 rows only";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> pagingProductByCID(int index, String cid) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where CategoryId=? order by ProductId OFFSET ? ROW fetch next 6 rows only";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			ps.setInt(2, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int countProductByCID(String cid) {
		String sql = "select count(*) from Product where CategoryId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
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
	public List<ProductModel> getProductByUseridSeller(String sellerid) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product Where sellerId = ?";
		try {

			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sellerid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBan(String id) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select productName,sum(quantity) as sl from Cart,CartDetail,Product where  Cartdetail.status=1 and Cart.cartId = Cartdetail.cartId and Product.productId = Cartdetail.productId and Product.sellerId=? group by ProductName";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel acount = SingletonServiceUtils.getUserDaoImpl().get(Integer.valueOf(id));
				CartModel cart = new CartModel();
				cart.setBuyer(acount);

				ProductModel product = new ProductModel();
				product.setProductName(rs.getString("ProductName"));

				CartItemModel cartItem = new CartItemModel();

				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("sl"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id, String date) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select productName,sum(quantity) as sl from Cart,Cartdetail,Product where Cartdetail.status=1 and Cart.cartId = Cartdetail.cartId and Product.productId = Cartdetail.productId and Product.sellerId=? and Cart.datecreate=? group by productName";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel acount = SingletonServiceUtils.getUserDaoImpl().get(Integer.valueOf(id));
				CartModel cart = new CartModel();
				cart.setBuyer(acount);

				ProductModel product = new ProductModel();
				product.setProductName(rs.getString("productName"));

				CartItemModel cartItem = new CartItemModel();
				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("sl"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;
	}

	@Override
	public void insertamount(int pid, String caid) {
		String sql = "update product set product.inventory=product.inventory +cartdetail.quantity from product inner join Cartdetail on Product.productId = Cartdetail.productId\r\n"
				+ "inner join cart on cart.cartId=Cartdetail.cartId\r\n"
				+ "where Product.productId=? and Cart.cartId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, caid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void insertsellamount(int pid, String caid) {
		String sql = "update product set product.sellamount=product.sellamount +cartdetail.quantity from product inner join Cartdetail on Product.productId = Cartdetail.productId\r\n"
				+ "inner join cart on cart.cartId=Cartdetail.cartId\r\n"
				+ "where Product.productId=? and Cart.cartId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, caid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void updateamount(int pid, String caid) {
		String sql = "update product set product.inventory=product.inventory -cartdetail.quantity from product inner join Cartdetail on Product.productId = Cartdetail.productId\r\n"
				+ "inner join cart on cart.cartId=Cartdetail.cartId\r\n"
				+ "where Product.productId=? and Cart.cartId=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, caid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
