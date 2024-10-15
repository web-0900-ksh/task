package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;

public class ProductFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("write")) {
			result = new Result();
			result.setPath("write.jsp");
		}else if(target.equals("write-ok")) {
		}else if(target.equals("list")) {
		}else if(target.equals("read")) {
		}else if(target.equals("update")) {
		}else if(target.equals("update-ok")) {
		}else if(target.equals("delete-ok")) {
		}else {
//			전부 notFound 404
		}
		
		if(result != null) {
			if(result.isRedirect()) {
//				redirect
				resp.sendRedirect(result.getPath());
			}else{
//				forward
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

