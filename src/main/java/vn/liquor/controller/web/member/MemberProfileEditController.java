package vn.liquor.controller.web.member;

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

@WebServlet(urlPatterns = { "/member/profile-edit" })
public class MemberProfileEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4178439679057663408L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
		AccountDetailModel accountDetailModel = SingletonServiceUtils.getUserDaoImpl().layaccountdetail(a.getUid());
		req.setAttribute("accountdetail", accountDetailModel);
		req.getRequestDispatcher("/views/member/profileedit.jsp").forward(req, resp);
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
				}
			}
			SingletonServiceUtils.getUserDaoImpl().editdetail(accountDetailModel);
			resp.sendRedirect(req.getContextPath() + "/member/profile");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
