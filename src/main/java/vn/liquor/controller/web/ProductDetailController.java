package vn.liquor.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.model.SellerModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/productdetail" })
public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3628078105096119980L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cid = req.getParameter("cid");
		String pid = req.getParameter("pid");
		List<ProductModel> listall = SingletonServiceUtils.getProductDaoImpl().getallproduct();
		List<CategoryModel> listallcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		ProductModel productdetail = SingletonServiceUtils.getProductDaoImpl().getproduct(pid);
		req.setAttribute("detailpro", productdetail);
		req.setAttribute("listallcate", listallcate);
		req.setAttribute("listall", listall);
		List<SellerModel> seller = SingletonServiceUtils.getSellerDaoImpl().getallseller();
		req.setAttribute("listsell", seller);
		req.getRequestDispatcher("/views/web/productdetail.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
