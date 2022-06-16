package controller.map;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.BoardDAO;
import dao.CommentDAO;
import dao.UserDAO;
import vo.BoardVO;
import vo.CommentVO;
import vo.UserVO;

public class ReadControlelr implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		BoardVO boardVO = new BoardDAO().selectId(id);
		UserVO userVO = new UserDAO().select(boardVO.getUserId());
		ArrayList<CommentVO> commentList = new CommentDAO().selectAll(id);
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("userVO", userVO);
		
		return new MyView("/view/read.jsp");
	}
}
