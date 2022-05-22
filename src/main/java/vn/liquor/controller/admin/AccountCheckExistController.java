package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/profile-check" })
public class AccountCheckExistController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1772562621341052268L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
	
		AccountDetailModel accountDetailModel = SingletonServiceUtils.getUserDaoImpl().layaccountdetail(a.getUid());

		if (accountDetailModel == null) {
			req.getRequestDispatcher("/views/admin/admin-addprofile.jsp").forward(req, resp);
		} else {
			req.setAttribute("accountdetail", accountDetailModel);
			req.getRequestDispatcher("/views/admin/adminoverviewpro.jsp").forward(req, resp);
		}
	}

}
