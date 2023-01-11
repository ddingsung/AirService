package com.air.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airMemberVO;

public class AirMemberUpdate implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		AirDAO dao = AirDAO.getInstance();
		airMemberVO vo = new airMemberVO();
		vo = dao.getMember(id);
		
		request.setAttribute("list", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/air/memberUpdate.jsp");
		rd.forward(request, response);
		
	}

}
