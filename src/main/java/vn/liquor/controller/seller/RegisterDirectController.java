package vn.liquor.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.liquor.model.SellerModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/registerredirect" })
public class RegisterDirectController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9183929471662947084L;
	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		String acc=req.getParameter("acc");

		if (acc.equals("null"))
		{
			resp.sendRedirect(req.getContextPath() +"/login");
		}
		else
		{
			
			if (SingletonServiceUtils.getSellerDaoImpl().getsellerbyuid(Integer.parseInt(acc))==null)
			{
				resp.sendRedirect(req.getContextPath() +"/registerseller");
			}
			else
			{
				SellerModel sell = SingletonServiceUtils.getSellerDaoImpl().getsellerbyuid(Integer.parseInt(acc));
				sess.setAttribute("sell", sell);
				resp.sendRedirect(req.getContextPath() +"/seller/home");
			}
			
		}
	}

}
