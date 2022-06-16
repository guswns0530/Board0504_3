package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.CommentDAO;
import vo.UserVO;

public class CommentInsertController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		CommentDAO commentDAO = new CommentDAO();
		
		// 로그인을 안했을 경우
		if(vo == null) {
			session.setAttribute("msg", "잘못된 접근입니다.");
			return new MyView("/", MyView.REDIRECT);	
		}
		
		String boardId = request.getParameter("boardId");
		String content = request.getParameter("content");
		String userId = vo.getUserId();
		
		int result = commentDAO.insert(boardId, userId, content);
		
		// db 등록 실패
		if(result <= 0) {
			session.setAttribute("msg", "댓글 등록에 실패하였습니다.");
		}
		
		return new MyView("/board/read?id=" + boardId, MyView.REDIRECT);
	}
}
