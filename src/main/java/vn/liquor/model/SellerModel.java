package vn.liquor.model;

public class SellerModel {
	private int id;
	private int uid;
	private String shopName;
	private String email;
	private String phone;
	@Override
	public String toString() {
		return "SellerModel [id=" + id + ", uid=" + uid + ", shopName=" + shopName + ", email=" + email + ", phone="
				+ phone + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public SellerModel(int id, int uid, String shopName, String email, String phone) {
		super();
		this.id = id;
		this.uid = uid;
		this.shopName = shopName;
		this.email = email;
		this.phone = phone;
	}
	public SellerModel() {
		super();
	}

}
