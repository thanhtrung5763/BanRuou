package vn.liquor.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/product" })
public class ProductListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5521335005637960899L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<ProductModel> listproduct = SingletonServiceUtils.getProductDaoImpl().getallproduct();
		List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		req.setAttribute("listcate", listcate);
		req.setAttribute("listproduct", listproduct);
		req.getRequestDispatcher("/views/admin/productlist.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
