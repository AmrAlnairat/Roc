package com.db_src;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class test2 {

	public static void main(String[] args) {
	
	System.out.print(FileDAO.getExamMark(9));
    System.out.print(FileDAO.getExamName(9));
    
    StudentDAO.insertMark(50, 9);
	}

}
