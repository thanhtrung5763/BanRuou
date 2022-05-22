package vn.liquor.model;

public class SellerInfoModel {
	private int SellerId;
	private String Province;
	private String District;
	private String FullAddress;
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getFullAddress() {
		return FullAddress;
	}
	public void setFullAddress(String fullAddress) {
		FullAddress = fullAddress;
	}
	@Override
	public String toString() {
		return "SellerInfoModel [SellerId=" + SellerId + ", Province=" + Province + ", District=" + District
				+ ", FullAddress=" + FullAddress + "]";
	}
	public SellerInfoModel(int sellerId, String province, String district, String fullAddress) {
		super();
		SellerId = sellerId;
		Province = province;
		District = district;
		FullAddress = fullAddress;
	}
	public SellerInfoModel() {
		super();
	}

}
