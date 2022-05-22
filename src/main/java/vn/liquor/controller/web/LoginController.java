package vn.liquor.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4256762711389845524L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		AccountModel account = SingletonServiceUtils.getLoginDaoImpl().login(username, password);
		if(account==null)
		{
			req.setAttribute("mess", "Sai tài khoản và password");
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}else
		{
			HttpSession session = req.getSession();
			session.setAttribute("acc", account);
			//resp.sendRedirect(req.getContextPath() + "/waiting");
			resp.sendRedirect("home");
		}
	}
}
