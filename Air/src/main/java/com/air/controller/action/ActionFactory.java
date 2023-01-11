package com.air.controller.action;



public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		if(command.equals("air_login_form")) {
			action = new AirLoginFormAction();
		}else if(command.equals("air_list")) {
			action = new AirListAction();
		}else if(command.equals("air_main_form")) {
			action = new AirMainFormAction();
		}else if(command.equals("main_search_form")) {
			action = new AirMainSearchForm();
		}else if(command.equals("tiketing_form")) {
			action = new AirTiketingForm();
		}else if(command.equals("login_check")) {
			action = new AirLoginCheck();
		}else if(command.equals("logout")) {
			action = new AirLogout();
		}else if(command.equals("air_join_form")) {
			action = new AirJoinForm();
		}else if(command.equals("id_Check_form")) {
			action = new AirIdCheckForm();
		}else if(command.equals("idCheck")) {
			action = new AirIdCheck();
		}else if(command.equals("Join")) {
			action = new AirJoin();
		}else if(command.equals("air_tiketing")) {
			action = new AirTiketing();
		}else if(command.equals("my_page")) {
			action = new AirMyPage();
		}else if(command.equals("member_tiket")) {
			action = new AirMemberTiket();
		}else if(command.equals("tiket_delete")) {
			action = new AirTiketDelete();
		}else if(command.equals("member_update")) {
			action = new AirMemberUpdate();
		}else if(command.equals("memberUpdate")){
			action = new AirUpdate();
		}else if(command.equals("root_page")) {
			action = new AirRootPageForm();
		}else if(command.equals("member_manager")) {
			action = new AirMemberManager();
		}else if(command.equals("air_manager")) {
			action = new AirManager();
		}else if(command.equals("air_update")) {
			action = new AirListUpdate();
		}
		
		
		return action;
	}

}
