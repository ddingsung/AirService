package com.air.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airInvenVO;
import com.air.dto.airMemberVO;

public class AirTiketing implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String air_name = request.getParameter("air_name");
		String id = request.getParameter("id");
		String air_sit = request.getParameter("air_sit");
		String pay = request.getParameter("pay");
		
		airInvenVO iVO = new airInvenVO();
		
		iVO.setAir_name(air_name);
		iVO.setId(id);
		iVO.setAir_sit(air_sit);
		iVO.setPay(pay);
		
		AirDAO dao = AirDAO.getInstance();
		dao.insertInventory(iVO);
		dao.updateAirSitStatusY(air_sit);
		
		List<airMemberVO> list = new ArrayList<airMemberVO>();
		list = dao.memberTiketInfo(id);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/air/airConfirm.jsp");
		rd.forward(request, response);
	}

}
