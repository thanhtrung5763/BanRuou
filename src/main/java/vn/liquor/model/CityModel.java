package vn.liquor.model;

public class CityModel {
	private int shipid;
	private String cityname;
	private int shipprice;

	public int getShipid() {
		return shipid;
	}

	public void setShipid(int shipid) {
		this.shipid = shipid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getShipprice() {
		return shipprice;
	}

	public void setShipprice(int shipprice) {
		this.shipprice = shipprice;
	}

	public CityModel(int shipid, String cityname, int shipprice) {
		super();
		this.shipid = shipid;
		this.cityname = cityname;
		this.shipprice = shipprice;
	}

	public CityModel() {
		super();
	}

	@Override
	public String toString() {
		return "CityModel [shipid=" + shipid + ", cityname=" + cityname + ", shipprice=" + shipprice + "]";
	}

}
