package vn.liquor.controller.admin;

import vn.liquor.util.SingletonServiceUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/admin/account/ban" })
public class AccountBanController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927090617717495402L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		SingletonServiceUtils.getUserDaoImpl().ban(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/account");
	}
}
