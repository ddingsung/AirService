package com.air.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airVO;

public class AirListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/air/airList.jsp";
		
		AirDAO aDAO = AirDAO.getInstance();
		List<airVO> list = aDAO.selectAllAir();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
