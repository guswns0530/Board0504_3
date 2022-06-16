package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.BoardDAO;
import vo.BoardVO;
import vo.UserVO;

public class BoardUpdateFormController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDAO dao = new BoardDAO();
		
		String boardId = request.getParameter("id");
		
		UserVO user = (UserVO) session.getAttribute("user");
		BoardVO vo = dao.selectId(boardId);
		String writeUserId = vo.getUserId();
		
		if(user != null && !user.getUserId().equals(writeUserId) || user == null) {
			session.setAttribute("msg", "잘못된 접근입니다.");
			return new MyView("/", MyView.REDIRECT);
		}
		
		request.setAttribute("boardVO", vo);
		
		return new MyView("/view/modify.jsp");
	}
}
