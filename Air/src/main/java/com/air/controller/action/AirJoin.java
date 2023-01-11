package com.air.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airMemberVO;

public class AirJoin implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String kname = request.getParameter("kname");
		String ename = request.getParameter("ename");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		AirDAO dao = AirDAO.getInstance();
		airMemberVO vo = new airMemberVO();
		
		vo.setId(id);
		vo.setPass(pass);
		vo.setKname(kname);
		vo.setEname(ename);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setGender(gender);
		
		dao.joinMember(vo);
		//dao.createMemberInventory(vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/air/airMain.jsp");
		rd.forward(request, response);
	}

}
