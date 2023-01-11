package com.air.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.air.dao.AirDAO;
import com.air.dto.airSitVO;

public class AirTiketingForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/air/airTiketing.jsp";
		
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		if(session == null) {
			url = "/air/airLogin.jsp";
			request.setAttribute("message", "로그인이 필요한 페이지입니다.");
		}else if (session != null) {
		request.setAttribute("name", name);
		AirDAO dao = AirDAO.getInstance();
		List<airSitVO> list = dao.getSitInfo();
		
		request.setAttribute("sit", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		}
	}

}
