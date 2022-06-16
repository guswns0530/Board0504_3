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

public class BoardUpdateController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDAO dao = new BoardDAO();
		
		String boardId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		UserVO user = (UserVO) session.getAttribute("user");
		BoardVO vo = dao.selectId(boardId);
		String writeUserId = vo.getUserId();
		
		if(user != null && !user.getUserId().equals(writeUserId) || user == null) {
			session.setAttribute("msg", "잘못된 접근입니다.");
			return new MyView("/", MyView.REDIRECT);
		}
		
		int result = dao.update(boardId, title, content);
		
		if(result <= 0) {
			session.setAttribute("msg", "처리중에 오류가 발생하였습니다.");
			return new MyView("/board/read?id=" + boardId, MyView.REDIRECT);
		}
		
		return new MyView("/board/read?id=" + boardId, MyView.REDIRECT);
	}
}
