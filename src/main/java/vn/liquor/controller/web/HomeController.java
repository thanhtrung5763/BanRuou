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
import vn.liquor.util.SingletonServiceUtils;
@WebServlet(urlPatterns = { "/home", "/trang-chu" })
public class HomeController extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 203632274729586389L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Khởi tạo các biến
		List<ProductModel> listtop1 = SingletonServiceUtils.getProductDaoImpl().gettop1product();
		List<ProductModel> listnew8 = SingletonServiceUtils.getProductDaoImpl().getnew8product();
		List<CategoryModel> listtop6cate = SingletonServiceUtils.getCategoryDaoImpl().get6cate();
		List<CategoryModel> listallcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		// Gán các list
		req.setAttribute("listtop1", listtop1);
		req.setAttribute("list8", listnew8);
		req.setAttribute("list6cate", listtop6cate);
		req.setAttribute("listallcate", listallcate);
		// req.setAttribute("lostnew8", listnew8);
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}
}
