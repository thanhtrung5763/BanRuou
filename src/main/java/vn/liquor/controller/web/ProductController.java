package vn.liquor.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3178898291991074448L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cid = req.getParameter("cid");
		String txtSearch = req.getParameter("txtS");
		// Khởi tạo các biến
		List<ProductModel> listall = SingletonServiceUtils.getProductDaoImpl().getallproduct();
		List<ProductModel> gettop1 = SingletonServiceUtils.getProductDaoImpl().gettop1product();
		List<CategoryModel> listallcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		List<ProductModel> listallbycid = SingletonServiceUtils.getProductDaoImpl().getallproductbycID(cid);
		// List<ProductModel> listnew8 = productservice.getnew8product();
		String indexPage = req.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		if ("0".equals(cid)) {
			int count = SingletonServiceUtils.getProductDaoImpl().CountProduct();
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			req.setAttribute("endP", endPage);
		} else {
			int count = SingletonServiceUtils.getProductDaoImpl().countProductByCID(cid);
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			req.setAttribute("endP", endPage);
		}
		int index = Integer.parseInt(indexPage);
		List<ProductModel> listp = SingletonServiceUtils.getProductDaoImpl().pagingProduct(index);
		List<ProductModel> listpbycid = SingletonServiceUtils.getProductDaoImpl().pagingProductByCID(index, cid);

		if ("0".equals(cid)) {
			req.setAttribute("listall", listp);
		} else {
			req.setAttribute("listall", listpbycid);
		}
		req.setAttribute("cid", cid);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		req.setAttribute("listallcate", listallcate);
		req.setAttribute("top1pro", gettop1);
		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
