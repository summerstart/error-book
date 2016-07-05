package com.example.book.user;

import java.io.Serializable;

public class Cuoti implements Serializable{
	private String type;
	private String section;
	private String reason;
	private String point;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public Cuoti() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuoti(String type, String section, String reason, String point) {
		super();
		this.type = type;
		this.section = section;
		this.reason = reason;
		this.point = point;
	}
	

}
