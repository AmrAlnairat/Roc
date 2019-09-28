package com.db_src;

import java.text.*;
import java.util.*;

import com.java_src.Exam;
import com.java_src.Question;
import com.java_src.Student;

import java.sql.*;

public class StudentDAO 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
	
	
	
   public static Student login(Student student) {
	
      //preparing some objects for connection 
      Statement stmt = null;    
	
      String email    = student.getEmail();    
      String password = student.getPassword();   
	    
      String searchQuery =
            "select * from student where student_email='"
                     + email
                     + "' AND student_password='"
                     + password
                     + "'";
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   System.out.println("Your email " + email);          
   System.out.println("Your password is " + password);
   System.out.println("Query: "+searchQuery);
	    
   try 
   {
      //connect to DB 
      currentCon = ConnectionManager.getConnection();
      stmt=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);	        
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered Student! Please sign up first");
         student.setValid(false);
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         
	     	
    	 int id = rs.getInt("student_id");
    	 String first_name   = rs.getString("student_fname");
    	 String middle_name  = rs.getString("student_mname");
    	 String last_name    = rs.getString("student_lname");
    	 String phone_number = rs.getString("student_pnumber");
    	
    	 
    	 
    	 student.setId(id);
    	 student.setFirstName(first_name);
    	 student.setMiddleName(middle_name);
    	 student.setLastName(last_name);
    	 student.setPhoneNumber(phone_number);
    	
    	 
    	 
         student.setValid(true);
      }
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
	
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
	
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }

         currentCon = null;
      }
   }

return student;
	
   }	



public static Student updateProfile(Student student) {
	
    //preparing some objects for connection 
    Statement stmt = null;    
	
    int id = student.getId();
    String email    =    student.getEmail();    
    String first_name =  student.getFirstName();
    String middle_name = student.getMiddleName();
    String last_name =   student.getLastName();
    String phone_number =student.getPhoneNumber();
    
	    
    String searchQuery =
          "update student set student_fname='"
                   + first_name 
                   + "' , student_mname='"
                   + middle_name
                   +"',student_lname='"
                   +last_name
                   +"',student_pnumber='"
                   +phone_number
                   +"',student_email='"
                   +email
                   +"'WHERE student_id='"
                   +id
                   + "'";
	    
 
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    stmt.executeUpdate(searchQuery);
    System.out.println("Sucess");
    stmt.close();
    
  
 } 

 catch (Exception ex) 
 {
    System.out.println("Update error " + ex);
 } 
	    
return student;
	
 }	






public static int getExamId(int studentId) {
	
    //preparing some objects for connection 
    Statement stmt = null;    
   
    int exam_id =0;
	    
    String searchQuery="select * from student where student_id='"+studentId+"'";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    while(rs.next()) {
    	exam_id = rs.getInt("exam_id") ;
    }
	       
    System.out.print("sucess");
    rs.close();
 } 

 catch (Exception ex) 
 {
    System.out.println("Log In failed: An Exception has occurred! " + ex);
 } 
	    
 //some exception handling
 finally 
 {
	 {

       currentCon = null;
    }
 }

return exam_id;
}




public static void insertMark(int mark ,int examId) {
	
    //preparing some objects for connection
	
    Statement stmt = null;    
	
       
    String searchQuery="update student set mark ='"+ mark +"'" +"where exam_id='" +examId +"'";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    stmt.executeUpdate(searchQuery);
    System.out.print("Insert sucess");
    stmt.close();
	       
  
 } 

 catch (Exception ex) 
 {
    System.out.println("error " + ex);
 } 
	    
 //some exception handling
 finally 
 {
    

       currentCon = null;
    
 }

}





}