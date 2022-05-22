package vn.liquor.controller.seller;


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

@WebServlet(urlPatterns = { "/seller/deleteproduct" })
public class DeleteProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2465022600087562292L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String proid = req.getParameter("pid");
		SingletonServiceUtils.getProductDaoImpl().deleteProduct(Integer.parseInt(proid));
		List<ProductModel> listproduct = SingletonServiceUtils.getProductDaoImpl().getallproduct();
		List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		req.setAttribute("listcate", listcate);
		req.setAttribute("listproduct", listproduct);
		resp.sendRedirect(req.getContextPath() + "/seller/listproduct");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
