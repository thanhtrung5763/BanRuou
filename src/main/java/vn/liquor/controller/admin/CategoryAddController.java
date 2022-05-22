package vn.liquor.controller.admin;

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

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.model.CategoryModel;
import vn.liquor.util.SingletonServiceUtils;
import vn.liquor.util.ConstantUtils;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9192123574146989121L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 AccountModel a = (AccountModel) session.getAttribute("acc");
		AccountDetailModel accountDetailModel = new AccountDetailModel();
		CategoryModel categoryModel = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				 if (item.getFieldName().equals("name")) {
					 categoryModel.setCname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("imageLink")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(ConstantUtils.DIR + "/category/" + fileName);
						item.write(file);
						categoryModel.setIcons("category/" + fileName);
					} else {
						categoryModel.setIcons(null);
					}
				}
			}
			SingletonServiceUtils.getCategoryDaoImpl().insert(categoryModel);
			resp.sendRedirect(req.getContextPath() + "/admin/home");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
}
