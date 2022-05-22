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

@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8545562062832729940L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    String cid = req.getParameter("cid");
	    String txtSearch = req.getParameter("txt");
	    //Khởi tạo các biến
	    List<ProductModel> listall = SingletonServiceUtils.getProductDaoImpl().getallproduct();
	    List<ProductModel> gettop1 = SingletonServiceUtils.getProductDaoImpl().gettop1product();
	    List<CategoryModel> listallcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
	    List<ProductModel> searchbynamepro = SingletonServiceUtils.getProductDaoImpl().SearchByProductName(txtSearch);
	    req.setAttribute("listall", searchbynamepro);
	    req.setAttribute("listall", searchbynamepro);
	   req.setAttribute("listallcate", listallcate);  
	    req.setAttribute("txtS", txtSearch);
	    req.setAttribute("top1pro", gettop1);
	    req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
