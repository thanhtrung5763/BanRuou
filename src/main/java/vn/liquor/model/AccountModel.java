package vn.liquor.model;

public class AccountModel {
	private int uid;
	private String username;
	private String password;
	private int isSeller;
	private int isAdmin;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountModel [uid=" + uid + ", username=" + username + ", password=" + password + ", isSeller="
				+ isSeller + ", isAdmin=" + isAdmin + ", status=" + status + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public AccountModel(int uid, String username, String password, int isSeller, int isAdmin, int status) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.isSeller = isSeller;
		this.isAdmin = isAdmin;
		this.status = status;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public AccountModel() {
		super();
	}
	
}
