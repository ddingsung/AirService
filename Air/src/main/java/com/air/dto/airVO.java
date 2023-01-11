package com.air.dto;

//create table air(
//num number(10) primary key,
//name varchar2(30) not null,
//boarding varchar2(20),
//landing varchar2(20),
//startpoint varchar2(20),
//destination varchar2(20),
//price number(20)
//);

public class airVO {
	private Integer num;
	private String name;
	private String boarding;
	private String landing;
	private String startpoint;
	private String destination;
	private Integer price;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoarding() {
		return boarding;
	}
	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}
	public String getLanding() {
		return landing;
	}
	public void setLanding(String landing) {
		this.landing = landing;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "airVO [num=" + num + ", name=" + name + ", boarding=" + boarding + ", landing=" + landing
				+ ", startpoint=" + startpoint + ", destination=" + destination + ", price=" + price + "]";
	}

}
