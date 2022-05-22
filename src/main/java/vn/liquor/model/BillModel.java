package vn.liquor.model;

public class BillModel {
	private CartModel cart;
	private CityModel city;
	private String fullname;
	private String phonenumber;
	private String fulladdress;
	private String email;
	private String payment;

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFulladdress() {
		return fulladdress;
	}

	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public BillModel(CartModel cart, CityModel city, String fullname, String phonenumber, String fulladdress,
			String email, String payment) {
		super();
		this.cart = cart;
		this.city = city;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.fulladdress = fulladdress;
		this.email = email;
		this.payment = payment;
	}

	public BillModel() {
		super();
	}

	@Override
	public String toString() {
		return "BillModel [cart=" + cart + ", city=" + city + ", fullname=" + fullname + ", fulladdress=" + fulladdress
				+ ", phonenumber=" + phonenumber + ", email=" + email + ", payment=" + payment + "]";
	}

}
