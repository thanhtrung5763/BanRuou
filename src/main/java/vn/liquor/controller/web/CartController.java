package vn.liquor.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vn.liquor.model.CategoryModel;
import vn.liquor.util.SingletonServiceUtils;


@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 321497340629221375L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<CategoryModel> listC = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		req.setAttribute("listallcate", listC);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/cart.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
