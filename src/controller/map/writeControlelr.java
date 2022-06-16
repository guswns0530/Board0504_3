package controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.BoardDAO;
import vo.BoardVO;
import vo.UserVO;

public class writeControlelr implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = ((UserVO) request.getSession().getAttribute("user")).getUserId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO(userId, title, content);
		
		int result = new BoardDAO().insert(vo);
				
		if(result > 0 ) {
			request.getSession().setAttribute("msg", "등록이 성공하였습니다.");
			return new MyView("/board/board", MyView.REDIRECT);
		} else {
			request.getSession().setAttribute("msg", "등록이 실패하였습니다.");
			return new MyView("/board/board", MyView.REDIRECT);
		}
	}

}
