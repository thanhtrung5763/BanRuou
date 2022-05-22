package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/account/memberprofile" })
public class MemberProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8162125996698420511L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String uid = req.getParameter("uid");
		AccountDetailModel account = SingletonServiceUtils.getUserDaoImpl().layaccountdetail(Integer.parseInt(uid));
		req.setAttribute("accountdetail", account);
		req.getRequestDispatcher("/views/admin/memberprofile.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
