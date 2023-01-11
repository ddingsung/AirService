package com.air.dto;

//create table air_member_inventory(
//num number(10) primary key,
//id varchar2(20),
//air_name varchar2(20),
//air_sit varchar2(10),
//tiket char(1) default 'N',
//pay varchar2(10)
//);

public class airInvenVO {
	private Integer num;
	private String id;
	private String air_name;
	private String air_sit;
	private String tiket;
	private String pay;
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
	@Override
	public String toString() {
		return "airInvenVO [num=" + num + ", id=" + id + ", air_name=" + air_name + ", air_sit=" + air_sit + ", tiket="
				+ tiket + ", pay=" + pay + "]";
	}

}
