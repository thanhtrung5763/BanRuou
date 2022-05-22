package vn.liquor.controller.admin;

import vn.liquor.util.SingletonServiceUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/account/unban" })
public class AccountUnbanController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -823459361257416051L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		SingletonServiceUtils.getUserDaoImpl().unban(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/account");
	}
}
