package com.air.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.air.dao.AirDAO;
import com.air.dto.airMemberVO;

public class AirLoginCheck implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		AirDAO dao = AirDAO.getInstance();
		String url = null;
		
		int result = dao.loginCheck(id, pass);
		if(result == 2 || result == 1) {
			airMemberVO vo = new airMemberVO();
			vo = dao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			session.setAttribute("result", result);
			url = "/air/airMain.jsp";
		}else {
			url = "/air/airLogin.jsp";
			if(result == 0) {
				request.setAttribute("message", "비밀번호를 확인해주세요");
			}else if (result == -1) {
				request.setAttribute("message", "아이디를 확인해주세요");
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
