package vn.liquor.controller.seller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;
import vn.liquor.util.ConstantUtils;

@WebServlet(urlPatterns = { "/seller/addproduct" })

public class AddProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5998553956588684147L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		req.setAttribute("listcate", listcate);
		req.getRequestDispatcher("/views/seller/addproduct.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		String sid = req.getParameter("sid");
		ProductModel product = new ProductModel();
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			System.out.print(items.size());
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setProductName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("category")) {
					product.setCategoryId(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("inventory")) {
					product.setInventory(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("discount")) {
					product.setDiscount(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(ConstantUtils.DIR + "/product/" + fileName);
					item.write(file);
					product.setImageLink("product/" + fileName);
				} else if (item.getFieldName().equals("sid")) {
					product.setSellerId(Integer.parseInt(item.getString()));
				}
			}
			product.setStatus(0);
			product.setSellAmount(0);
			SingletonServiceUtils.getProductDaoImpl().insertProduct(product);
			req.setAttribute("alert", "Th�m th�nh c�ng");
			req.getRequestDispatcher("/views/seller/addproduct.jsp").forward(req, resp);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
