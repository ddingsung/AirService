package com.air.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airVO;

public class AirListUpdate implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		AirDAO dao = AirDAO.getInstance();
		airVO vo = dao.selectSearchAir(name);
		
		request.setAttribute("list", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/air/airUpdateForm.jsp");
		rd.forward(request, response);
	}

}
