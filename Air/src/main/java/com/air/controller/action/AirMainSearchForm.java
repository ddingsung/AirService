package com.air.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airVO;

public class AirMainSearchForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String url = null;
		
		
		String startpoint = request.getParameter("startpoint");
		String destination = request.getParameter("destination");
		
		AirDAO dao = AirDAO.getInstance();
		List<airVO> list = dao.selectSearchAir(startpoint, destination);
		request.setAttribute("list", list);
		if(list == null) {
			request.setAttribute("message", "입력하신곳은 항공편이 존재하지않습니다.");
			url = "/air/errorPage.jsp";
		}else if (!(list == null)) {
			url = "/air/searchResult.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
