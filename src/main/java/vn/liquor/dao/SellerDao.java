package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.SellerInfoModel;
import vn.liquor.model.SellerModel;

public interface SellerDao {
	void registerseller(SellerModel seller);

	void registerinfo(SellerInfoModel sellerinfo);

	SellerModel checkshopname(String shopname);

	SellerModel getsellerbyuid(int uid);

	void updateisseller(int uid);

	List<SellerModel> getallseller();
}
