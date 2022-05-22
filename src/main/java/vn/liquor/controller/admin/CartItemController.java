package vn.liquor.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CartItemModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/admin/cartitem" })
public class CartItemController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6913614070590980031L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String cartid = req.getParameter("cartid");
		List<CartItemModel> allcartitem = SingletonServiceUtils.getCartItemDaoImpl().getAllCartItem(cartid);
		req.setAttribute("allcartitem", allcartitem);

		req.getRequestDispatcher("/views/admin/cartitem.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
