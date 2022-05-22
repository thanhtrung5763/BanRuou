package vn.liquor.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.CartItemModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/thongke" })
public class SellerThongKeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1048321564932606309L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String userid = req.getParameter("userid");
		String date = req.getParameter("date");
		HttpSession session = req.getSession();
		session.setAttribute("userid", userid);

		List<ProductModel> product = SingletonServiceUtils.getProductDaoImpl().getProductByUseridSeller(userid);
		List<CartItemModel> cartitem = SingletonServiceUtils.getProductDaoImpl().ThongkeSLSanDaBan(userid);
		req.setAttribute("userid", userid);
		req.setAttribute("product", product);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date", date);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/thongkeseller.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("userid");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String date = req.getParameter("from_date");
		List<ProductModel> product = SingletonServiceUtils.getProductDaoImpl().getProductByUseridSeller(userid);
		List<CartItemModel> cartitem = SingletonServiceUtils.getProductDaoImpl().ThongkeSLSanDaBanTheoNgay(userid, date);
		System.out.print(product);
		req.setAttribute("product", product);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date", date);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/thongkeseller.jsp");
		dispatcher.forward(req, resp);
	}
}
