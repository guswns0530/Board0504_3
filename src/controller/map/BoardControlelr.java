package controller.map;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.BoardDAO;
import util.PagiNation;
import vo.BoardVO;

public class BoardControlelr implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		String query = request.getParameter("query");
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = null;
		int cntPage;
		
		if(query != null) {
			list = dao.selectAll(page, query);
			cntPage= dao.countAll(query);
		} else {
			list = dao.selectAll(page);
			cntPage = dao.countAll();
		}
		
		PagiNation pn = new PagiNation(page, cntPage); 
		
		request.setAttribute("pagination", pn);
		request.setAttribute("list", list);
		
		return new MyView("/view/board.jsp");
	}
	
}

