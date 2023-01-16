package com.air.dto;


//create table air_member(
//num number(10) primary key,
//id varchar2(20) not null,
//pass varchar2(20) not null,
//kname varchar2(20),
//ename varchar2(30),
//phone varchar2(30),
//email varchar2(30),
//gender char(1) default 'M',
//point number(30) default 0,
//root varchar2(1) default 'B',
//air_name varchar2(20),
//air_sit varchar2(20),
//tiket varchar2(20),
//pay varchar2(20)
//);
//
//
//create SEQUENCE air_mem_seq  INCREMENT by 1 start with 1;

public class airMemberVO {
	private Integer num;
	private String id;
	private String pass;
	private String kname;
	private String ename;
	private String phone;
	private String email;
	private String gender;
	private Integer point;
	private String root;
	private String air_name;
	private String air_sit;
	private String tiket;
	private String pay;
	
	public String getAir_name() {
		return air_name;
	}
	public void setAir_name(String air_name) {
		this.air_name = air_name;
	}
	public String getAir_sit() {
		return air_sit;
	}
	public void setAir_sit(String air_sit) {
		this.air_sit = air_sit;
	}
	public String getTiket() {
		return tiket;
	}
	public void setTiket(String tiket) {
		this.tiket = tiket;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	@Override
	public String toString() {
		return "airMemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", kname=" + kname + ", ename=" + ename
				+ ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", point=" + point + ", root=" + root
				+ ", air_name=" + air_name + ", air_sit=" + air_sit + ", tiket=" + tiket + ", pay=" + pay + "]";
	}
	
	

}
