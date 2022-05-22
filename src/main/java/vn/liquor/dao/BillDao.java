package vn.liquor.dao;

import vn.liquor.model.BillModel;

public interface BillDao {
	public void insert(BillModel bill);

	public BillModel getbillbycaid(String caid);

}
