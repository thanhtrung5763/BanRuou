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
import vn.liquor.util.SingletonServiceUtils;
import vn.liquor.util.ConstantUtils;
@WebServlet(urlPatterns = { "/admin/profile-add" })
public class ProfileAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6107150945394326689L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
		AccountDetailModel accountDetailModel = new AccountDetailModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				accountDetailModel.setUid(a.getUid());
				if (item.getFieldName().equals("name")) {
					accountDetailModel.setFullname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("cmnd")) {
					accountDetailModel.setCmnd(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("diachi")) {
					accountDetailModel.setDiachi(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("sdt")) {
					accountDetailModel.setSdt(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("imageLink")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(ConstantUtils.DIR + "/user/" + fileName);
						item.write(file);
						accountDetailModel.setImageLink("user/" + fileName);
					} else {
						accountDetailModel.setImageLink(null);
					}
				}
			}
			System.out.print(accountDetailModel);
			SingletonServiceUtils.getUserDaoImpl().adddetail(accountDetailModel);
			resp.sendRedirect(req.getContextPath() + "/admin/profile-check");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
