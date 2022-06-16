package controller.map;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.UserDAO;
import vo.UserVO;

public class RegisterController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("pwd");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		
		UserVO vo = new UserVO(userId, password, userName, userNickname);
		
		int result = new UserDAO().insert(vo);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("msg", "회원가입에 성공하셨습니다.");
			return new MyView("/", MyView.REDIRECT);
		} else {
			session.setAttribute("msg", "회원가입에 실패하셨습니다.");
			return new MyView("/board/register", MyView.REDIRECT);
		}
	}

}
