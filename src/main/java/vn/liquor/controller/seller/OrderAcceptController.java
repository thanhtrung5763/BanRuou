package vn.liquor.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CartItemModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/seller/order/accept" })
public class OrderAcceptController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6574130615613495360L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	String ciid=req.getParameter("ciid");
	String caid=req.getParameter("caid");
	CartItemModel cartitem = SingletonServiceUtils.getCartItemDaoImpl().getbycitemid(Integer.parseInt(ciid));
	SingletonServiceUtils.getCartItemDaoImpl().accept(Integer.parseInt(ciid));
	SingletonServiceUtils.getProductDaoImpl().insertsellamount(cartitem.getProduct().getProductId(), caid);
	resp.sendRedirect(req.getContextPath() +"/seller/order");
}
}
