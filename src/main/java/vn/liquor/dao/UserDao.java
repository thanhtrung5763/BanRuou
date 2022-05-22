package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;

public interface UserDao {
	void insert(AccountModel user);
	void editdetail(AccountDetailModel user);
	AccountModel get(int id);
	int countAllAccount();
	public AccountDetailModel layaccountdetail(int id);
	void editdetailimage(AccountDetailModel user);
	List<AccountModel> getalluser();
	List<AccountDetailModel> getalluserdetail();
	void ban(int id);
	void unban(int id);
	void delete(int id);
	void deletedetail(int id);
	void register(AccountModel acc);
	void adddetail(AccountDetailModel user);
	AccountModel checkuser(String username);
}
