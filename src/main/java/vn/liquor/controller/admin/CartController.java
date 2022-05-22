package vn.liquor.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.CartModel;
import vn.liquor.util.SingletonServiceUtils;


@WebServlet(urlPatterns = { "/admin/cart" })
public class CartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 836308792572271910L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		List<CartModel> cartModel = SingletonServiceUtils.getCartDaoImpl().getAllCart();
		List<AccountDetailModel> accountdetail = SingletonServiceUtils.getUserDaoImpl().getalluserdetail();
		req.setAttribute("allcart", cartModel);
		req.setAttribute("accountdetail", accountdetail);

		req.getRequestDispatcher("/views/admin/giohang.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
