package com.air.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;

public class AirIdCheck implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		AirDAO dao = AirDAO.getInstance();
		int result = dao.confirmID(id);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/air/airIdCheck.jsp");
		rd.forward(request, response);
	}

}
