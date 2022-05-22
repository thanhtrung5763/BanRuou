package vn.liquor.model;

public class CartItemModel {
	private int id;
	private CartModel cartid;
	private ProductModel product;
	private int unitPrice;
	private int quantity;
	private int subtotal;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CartModel getCartid() {
		return cartid;
	}

	public void setCartid(CartModel cartid) {
		this.cartid = cartid;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public CartItemModel() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CartItemModel(int id, CartModel cartid, ProductModel product, int unitPrice, int quantity, int subtotal,
			int status) {
		super();
		this.id = id;
		this.cartid = cartid;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CartItemModel [id=" + id + ", cartid=" + cartid + ", product=" + product + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}

	public CartItemModel(CartModel cartid, ProductModel product, int unitPrice, int quantity, int subtotal,
			int status) {
		super();
		this.cartid = cartid;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.status = status;
	}

}
