package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.UserDAO;
import vo.UserVO;

public class LoginControlelr implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		UserVO vo = new UserDAO().select(userId, pwd);

		HttpSession session = request.getSession();
		
		if(vo == null) {
			session.setAttribute("msg", "로그인에 실패하였습니다. 아이디와 비번을 다시 확인해주세요.");
			return new MyView("/board/login", MyView.REDIRECT);	
		}
		
		session.setAttribute("msg", "로그인에 성공하였습니다.");
		session.setAttribute("user", vo);
		return new MyView("/", MyView.REDIRECT);
	}

}
