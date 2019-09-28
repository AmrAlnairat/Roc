package com.java_src;

import java.util.ArrayList;

public class Answer {
  
	private String name;
	private int id;
	private int correct;
	
	public Answer(String name, int correct) {
		this.name = name;
		this.correct = correct;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int isCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	
	
	

 
}
