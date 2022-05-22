package vn.liquor.controller.admin;

import vn.liquor.util.SingletonServiceUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5597183858700700666L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		SingletonServiceUtils.getCategoryDaoImpl().delete(Integer.parseInt(cid));
		resp.sendRedirect(req.getContextPath() + "/admin/category");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
