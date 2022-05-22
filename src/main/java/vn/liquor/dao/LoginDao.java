package vn.liquor.dao;

import vn.liquor.model.AccountModel;

public interface LoginDao {
	 AccountModel login(String user, String pass);
}
