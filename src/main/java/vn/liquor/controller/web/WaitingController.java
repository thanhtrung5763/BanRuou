package vn.liquor.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.liquor.model.AccountModel;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 305691941532656994L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("acc") != null) {
			AccountModel account = (AccountModel) session.getAttribute("acc");
			req.setAttribute("acc", account.getUsername());

			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
