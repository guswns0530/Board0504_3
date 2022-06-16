package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.BoardDAO;
import dao.UserDAO;
import vo.UserVO;

public class BoardDeleteController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDAO dao = new BoardDAO();
		
		String boardId = request.getParameter("id");
		
		UserVO user = (UserVO) session.getAttribute("user");
		String writeUserId = dao.selectId(boardId).getUserId();
		
		if(user != null && !user.getUserId().equals(writeUserId) || user == null) {
			session.setAttribute("msg", "잘못된 접근입니다.");
			return new MyView("/", MyView.REDIRECT);
		}
		
		int result = dao.delete(boardId);
		
		// 실패
		if(result <= 0) {
			session.setAttribute("msg", "삭제중 오류가 발생하였습니다.");
			
			return new MyView("/board/board", MyView.REDIRECT);
		}
		
		session.setAttribute("msg", "정상적으로 삭제되었습니다.");
		
		return new MyView("/board/board", MyView.REDIRECT);
	}
}

