package vn.liquor.model.dao;

import java.util.List;

import vn.liquor.model.CityModel;

public interface CityDao {
	public void insertcity(CityModel city);

	public void updatecity(CityModel city);

	public void delcity(int id);

	public List<CityModel> getallcity();

	public CityModel getcitybyid(int id);
}
