package com.air.dto;

//create table air_sit(
//name varchar2(10),
//row_sit char(1),
//col_sit char(1),
//status char(1) default 'N'
//);

public class airSitVO {
	private String name;
	private String row_sit;
	private String col_sit;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRow_sit() {
		return row_sit;
	}
	public void setRow_sit(String row_sit) {
		this.row_sit = row_sit;
	}
	public String getCol_sit() {
		return col_sit;
	}
	public void setCol_sit(String col_sit) {
		this.col_sit = col_sit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "airSitVO [name=" + name + ", row_sit=" + row_sit + ", col_sit=" + col_sit + ", status=" + status + "]";
	}

}
