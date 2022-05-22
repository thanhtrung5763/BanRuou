package vn.liquor.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.model.CityModel;
import vn.liquor.util.SingletonServiceUtils;


@WebServlet(urlPatterns = { "/checkoutinfo" })
public class CheckoutInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337982311856124391L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AccountModel users = (AccountModel) httpSession.getAttribute("acc");
		if (users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			AccountDetailModel account = SingletonServiceUtils.getUserDaoImpl().layaccountdetail(users.getUid());
			httpSession.setAttribute("accdetail", account);
			req.getRequestDispatcher("/views/web/checkoutinfo.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		String name = req.getParameter("fullname");
		String add = req.getParameter("fulladdress");
		String city = req.getParameter("selectcity");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		AccountModel users = (AccountModel) httpSession.getAttribute("acc");
		if (users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			AccountDetailModel account = new AccountDetailModel();
			account.setFullname(name);
			account.setDiachi(add);
			account.setSdt(phone);
			account.setImageLink(email);
			httpSession.setAttribute("accdetail", account);
			CityModel ct = SingletonServiceUtils.getCityDaoImpl().getcitybyid(Integer.parseInt(city));
			httpSession.setAttribute("city", ct);
			req.getRequestDispatcher("/views/web/checkoutinfo.jsp").forward(req, resp);
		}
	}
}
