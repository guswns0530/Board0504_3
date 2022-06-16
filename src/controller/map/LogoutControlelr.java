package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;

public class LogoutControlelr implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if(user != null) {
			session.removeAttribute("user");
		}
		
		session.setAttribute("msg", "로그아웃에 성공하셨습니다.");
		return new MyView("/", MyView.REDIRECT);
	}

}
