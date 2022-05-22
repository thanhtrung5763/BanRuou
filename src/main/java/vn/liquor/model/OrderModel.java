package vn.liquor.model;

public class OrderModel {
	private CartItemModel cartitem;
	private ProductModel product;
	private BillModel bill;
	public CartItemModel getCartitem() {
		return cartitem;
	}
	public void setCartitem(CartItemModel cartitem) {
		this.cartitem = cartitem;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public BillModel getBill() {
		return bill;
	}
	public void setBill(BillModel bill) {
		this.bill = bill;
	}
	public OrderModel(CartItemModel cartitem, ProductModel product, BillModel bill) {
		super();
		this.cartitem = cartitem;
		this.product = product;
		this.bill = bill;
	}
	public OrderModel() {
		super();
	}
	@Override
	public String toString() {
		return "OrderModel [cartitem=" + cartitem + ", product=" + product + ", bill=" + bill + "]";
	}
	
	
	
}
