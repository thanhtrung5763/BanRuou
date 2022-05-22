package vn.liquor.model;

public class AccountDetailModel {
	private int uid;
	private String fullname;
	private String cmnd;
	private String sdt;
	private String diachi;
	private String imageLink;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public AccountDetailModel(int uid, String fullname, String cmnd, String sdt, String diachi, String imageLink) {
		super();
		this.uid = uid;
		this.fullname = fullname;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.diachi = diachi;
		this.imageLink = imageLink;
	}
	public AccountDetailModel() {
		super();
	}
	@Override
	public String toString() {
		return "AccountDetailModel [uid=" + uid + ", fullname=" + fullname + ", cmnd=" + cmnd + ", sdt=" + sdt
				+ ", diachi=" + diachi + ", imageLink=" + imageLink + "]";
	}

}
