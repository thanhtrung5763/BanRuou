package vn.liquor.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.OrderModel;
import vn.liquor.model.SellerModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/seller/order" })
public class OrderDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1669669688476173063L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		SellerModel sell = (SellerModel) sess.getAttribute("sell");
		System.out.print(sell);
		List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		req.setAttribute("listcate", listcate);
		List<OrderModel> listorder = SingletonServiceUtils.getOrderDaoImpl().getorderbysid(sell.getId());
		for (OrderModel orderModel : listorder) {
			System.out.print(orderModel);
		}
		req.setAttribute("listorder", listorder);
		req.getRequestDispatcher("/views/seller/Orderlist.jsp").forward(req, resp);
	}
}
