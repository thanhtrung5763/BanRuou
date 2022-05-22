package vn.liquor.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CartModel implements Serializable {

	private String id;
	private AccountModel buyer;
	private Date buyDate;
	private int total;

	public int getTotal() {
		return total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AccountModel getBuyer() {
		return buyer;
	}

	public void setBuyer(AccountModel buyer) {
		this.buyer = buyer;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public CartModel(String id, AccountModel buyer, Date buyDate, int total) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.total = total;
	}

	public CartModel() {
		super();
	}

	@Override
	public String toString() {
		return "CartModel [id=" + id + ", buyer=" + buyer + ", buyDate=" + buyDate + ", total=" + total + "]";
	}

}
