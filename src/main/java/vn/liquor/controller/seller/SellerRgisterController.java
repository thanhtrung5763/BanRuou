package vn.liquor.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.liquor.model.SellerInfoModel;
import vn.liquor.model.SellerModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/registerseller" })
public class SellerRgisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1683838755493772454L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/views/seller/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("shopname");
		String prov = req.getParameter("province");
		String dis = req.getParameter("district");
		String fadd = req.getParameter("fulladdress");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String userid = req.getParameter("userId");

		SellerModel sell = SingletonServiceUtils.getSellerDaoImpl().checkshopname(name);
		if (sell == null) {
			SellerModel seller = new SellerModel();
			System.out.print("/" + userid);
			seller.setUid(Integer.parseInt(userid));
			seller.setShopName(name);
			seller.setPhone(phone);
			seller.setEmail(email);
			SingletonServiceUtils.getSellerDaoImpl().registerseller(seller);
			seller = SingletonServiceUtils.getSellerDaoImpl().getsellerbyuid(Integer.parseInt(userid));
			HttpSession sess = req.getSession();
			sess.setAttribute("sell", seller);
			SellerInfoModel sellerinfo = new SellerInfoModel();
			sellerinfo.setSellerId(seller.getId());
			sellerinfo.setProvince(prov);
			sellerinfo.setDistrict(dis);
			sellerinfo.setFullAddress(fadd);
			SingletonServiceUtils.getSellerDaoImpl().registerinfo(sellerinfo);
			SingletonServiceUtils.getSellerDaoImpl().updateisseller(Integer.parseInt(userid));
			req.setAttribute("alert", "1");
			req.getRequestDispatcher("/views/seller/registertemp.jsp").forward(req, resp);
		} else {
			req.setAttribute("alert", "0");
			req.getRequestDispatcher("/views/seller/registertemp.jsp").forward(req, resp);
		}

	}
}
