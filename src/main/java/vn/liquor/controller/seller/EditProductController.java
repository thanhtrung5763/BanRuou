package vn.liquor.controller.seller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.util.SingletonServiceUtils;
import vn.liquor.util.ConstantUtils;

@WebServlet(urlPatterns = { "/seller/editproduct" })
public class EditProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5427156447695968587L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String productId = req.getParameter("pid");
		int pid = Integer.parseInt(productId);
		List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
		ProductModel product = SingletonServiceUtils.getProductDaoImpl().getproductbypid(pid);
		req.setAttribute("listcate", listcate);
		req.setAttribute("product", product);
		HttpSession sess = req.getSession();
		sess.setAttribute("pro", productId);
		req.getRequestDispatcher("/views/seller/editproduct.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		String proid = (String) sess.getAttribute("pro");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		ProductModel product = new ProductModel();
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);

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

					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(ConstantUtils.DIR + "/product/" + fileName);
						item.write(file);
						product.setImageLink("product/" + fileName);
					} else
						product.setImageLink(null);
				} else if (item.getFieldName().equals("sid")) {
					System.out.print(item.getString());
					product.setSellerId(Integer.parseInt(item.getString()));
				}

			}
			product.setStatus(0);
			product.setSellAmount(0);
			product.setProductId(Integer.parseInt(proid));
			SingletonServiceUtils.getProductDaoImpl().updateProduct(product);
			req.setAttribute("alert", "Th�m th�nh c�ng");
			List<ProductModel> listproduct = SingletonServiceUtils.getProductDaoImpl().getallproduct();
			List<CategoryModel> listcate = SingletonServiceUtils.getCategoryDaoImpl().getallCate();
			req.setAttribute("listcate", listcate);
			req.setAttribute("listproduct", listproduct);
			sess.removeAttribute("pro");
			resp.sendRedirect(req.getContextPath() + "/seller/listproduct");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
