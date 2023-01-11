package com.air.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.dao.AirDAO;
import com.air.dto.airMemberVO;
import com.air.dto.airVO;

public class AirMemberManager implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		AirDAO dao = AirDAO.getInstance();
		
		List<airMemberVO> mlist = dao.memberTiketInfoAll();
		String name = "";
		for(int i = 0; i < mlist.size(); i ++) {
			name = mlist.get(i).getAir_name();
		}
		List<airVO> alist = dao.selectAirName(name);
		
		request.setAttribute("mlist", mlist);
		request.setAttribute("alist", alist);
		RequestDispatcher rd = request.getRequestDispatcher("/air/MemberManageForm.jsp");
		rd.forward(request, response);
	}

}
