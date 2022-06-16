package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {
	public final static int FOWARD = 100;
	public final static int REDIRECT = 101;
	
	private String path = "";
	private int type = 0;
	
	public MyView(String path, int type) {
		this.path = path;
		this.type = type;
	}
	
	public MyView(String path) {
		this.path = path;
		this.type = MyView.FOWARD;
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(this.type == MyView.FOWARD) {
			request.getRequestDispatcher(path).forward(request, response);
		} else if (this.type == MyView.REDIRECT) {
			response.sendRedirect(request.getContextPath() + path);
		}
	}
}
