package vn.liquor.model;

public class CategoryModel {
	private int cateid;
	private String cname;
	private String icons;
	
	public CategoryModel(int cateid, String cname, String icons) {
		super();
		this.cateid = cateid;
		this.cname = cname;
		this.icons = icons;
	}
	public CategoryModel() {
		super();
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIcons() {
		return icons;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}
	@Override
	public String toString() {
		return "CategoryModel [cateid=" + cateid + ", cname=" + cname + ", icons=" + icons + "]";
	}
	
	
}
