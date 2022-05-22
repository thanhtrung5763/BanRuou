package vn.liquor.model;

public class ProductModel {
	private int productId;
	private String productName;
	private String description;
	private int price;
	private String imageLink;
	private int categoryId;
	private int sellerId;
	private int sellAmount;
	private int inventory;
	private int discount;
	private int status;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getSellAmount() {
		return sellAmount;
	}
	public void setSellAmount(int sellAmount) {
		this.sellAmount = sellAmount;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", imageLink=" + imageLink + ", categoryId=" + categoryId + ", sellerId="
				+ sellerId + ", sellAmount=" + sellAmount + ", inventory=" + inventory + ", discount=" + discount
				+ ", status=" + status + "]";
	}
	public ProductModel(int productId, String productName, String description, int price, String imageLink,
			int categoryId, int sellerId, int sellAmount, int inventory, int discount, int status) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageLink = imageLink;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.sellAmount = sellAmount;
		this.inventory = inventory;
		this.discount = discount;
		this.status = status;
	}
	public ProductModel() {
		super();
	}
	
}