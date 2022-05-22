package vn.liquor.controller.web.member;

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


@WebServlet(urlPatterns = { "/member/profile" })
public class MemberProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -882188322042829317L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
		if (a == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			AccountDetailModel accountDetailModel = SingletonServiceUtils.getUserDaoImpl().layaccountdetail(a.getUid());
			if (accountDetailModel == null) 
			{
				req.getRequestDispatcher("/views/member/member-addprofile.jsp").forward(req, resp);
			} else
			{
				req.setAttribute("accountdetail", accountDetailModel);
				req.getRequestDispatcher("/views/member/memberoverviewpro.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
