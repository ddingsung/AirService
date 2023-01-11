package com.air.controller.action;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.air.dao.AirDAO;

public class AirTiketDelete implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String air_sit = request.getParameter("air_sit");
		
		String sid = request.getParameter("sid");
		if (!(id.equals(sid))) {
			request.setAttribute("message", "접근할수없습니다");
			RequestDispatcher rd = request.getRequestDispatcher("air/errorPage.jsp");
			rd.forward(request, response);
		}else {
			AirDAO dao = AirDAO.getInstance();
			dao.deleteInventory(sid, air_sit, name);
			dao.updateAirSitStatusN(air_sit);
			
			new AirMemberTiket().execute(request, response);
		}
	}

}
