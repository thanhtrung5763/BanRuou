package vn.liquor.dao;

import java.util.List;

import vn.liquor.model.CategoryModel;

public interface CategoryDao {
	List<CategoryModel> get6cate();
	List<CategoryModel> getallCate();
	int CountAllCate();
	void insert(CategoryModel cate);
	void delete(int cid);
	CategoryModel getCate(int cid);
	void edit(CategoryModel cate);
}
