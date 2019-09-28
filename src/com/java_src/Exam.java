package com.java_src;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Exam {
    
	private int id;
	private String name;
	private Time startTime;
	private Time endTime;
	private Date date;
	private int mark;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Exam( String name, Time startTime, Time endTime, Date date, int mark) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.mark = mark;
	}


	public Exam(String name) {
		this.name = name;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Time getStartTime() {
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	public Time getEndTime() {
		return endTime;
	}


	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	
	
	
	
    
	
}
