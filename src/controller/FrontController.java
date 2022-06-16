package controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.map.BoardControlelr;
import controller.map.BoardDeleteController;
import controller.map.BoardUpdateController;
import controller.map.BoardUpdateFormController;
import controller.map.CommentInsertController;
import controller.map.LoginControlelr;
import controller.map.LoginFormControlelr;
import controller.map.LogoutControlelr;
import controller.map.ReadControlelr;
import controller.map.RegisterController;
import controller.map.RegisterFormControlelr;
import controller.map.WriteFormControlelr;
import controller.map.writeControlelr;

@WebServlet("/board/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, Controller> controllerMap;
	
	@Override
	public void init() throws ServletException {
		controllerMap = new HashMap<>();
		
		// view 매칭
		controllerMap.put("/register", new RegisterFormControlelr());
		controllerMap.put("/write", new WriteFormControlelr());
		controllerMap.put("/board", new BoardControlelr());
		controllerMap.put("/read", new ReadControlelr());
		controllerMap.put("/login", new LoginFormControlelr());
		controllerMap.put("/logout", new LogoutControlelr());
		controllerMap.put("/commentInsert", new CommentInsertController());
		controllerMap.put("/boardDelete", new BoardDeleteController());
		controllerMap.put("/boardUpdate", new BoardUpdateFormController());
		
		// form 확인
		controllerMap.put("/boardUpdateCheck", new BoardUpdateController());
		controllerMap.put("/registerCheck", new RegisterController());
		controllerMap.put("/loginCheck", new LoginControlelr());
		controllerMap.put("/writeCheck", new writeControlelr());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String path = req.getRequestURI().substring((req.getContextPath() + "/board" ).length());
		
		Controller ctr = controllerMap.get(path);
		MyView view = null;
		
		if(ctr == null) {
			view = new MyView("/view/404.jsp");
		} else {
			view = ctr.process(req, resp);
		}
		
		view.process(req, resp);
	}
}
