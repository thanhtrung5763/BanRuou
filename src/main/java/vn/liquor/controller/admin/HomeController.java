package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/home" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973529570469279629L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int tongsanpham = SingletonServiceUtils.getProductDaoImpl().CountProduct();
		int tongdanhmuc = SingletonServiceUtils.getCategoryDaoImpl().CountAllCate();
		int tongaccount = SingletonServiceUtils.getUserDaoImpl().countAllAccount();
		req.setAttribute("tongsanpham", tongsanpham);
		req.setAttribute("tongdanhmuc", tongdanhmuc);
		req.setAttribute("tongaccount", tongaccount);
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
