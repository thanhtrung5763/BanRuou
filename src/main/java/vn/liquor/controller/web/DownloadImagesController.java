package vn.liquor.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import vn.liquor.util.ConstantUtils;

@WebServlet(urlPatterns = "/image") // ?fname=abc.png
public class DownloadImagesController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3960627759646844061L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fname");
		File file = new File(ConstantUtils.DIR + "/" + fileName);
		resp.setContentType("image/jpeg"); 
		if (file.exists()) {
			IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
		}
	}
}
