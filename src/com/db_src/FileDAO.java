package com.db_src;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import com.java_src.*;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class FileDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;  
		

	
		
public static Exam insertExam(Exam exam) {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
		  String examName=exam.getName();
	      Date  date = exam.getDate();
	      Time  startTime = exam.getStartTime();
	      Time  endTime = exam.getStartTime();
	      int   mark    = exam.getMark() ;
	      
		    
	      String searchQuery="insert into exam(exam_name ,exam_date ,exam_stime,exam_etime,exam_mark)"
	      		  +"values(?,?,?,?,?)";
	           
	
		    
	   try 
	   {
		   //connect to DB 
		    currentCon = ConnectionManager.getConnection();
		    PreparedStatement stmt1=currentCon.prepareStatement(searchQuery);
		    
		    stmt1.setString(1, examName);
		    stmt1.setDate(2, date);
		    stmt1.setTime(3,startTime);
		    stmt1.setTime(4,endTime);
		    stmt1.setInt(5, mark);
		    stmt1.execute();
		    
		    System.out.print("Insert sucess");
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("error " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
		   {

	         currentCon = null;
	      }
	   }

	return exam;
  }


public static Exam getExamId(Exam exam) {
	
    //preparing some objects for connection 
    Statement stmt = null;    
	String examName=exam.getName();
   
	    
    String searchQuery="select * from exam where exam_name='"+examName+"'";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    while(rs.next()) {
    	exam.setId(rs.getInt("exam_id"));
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

return exam;
}

public static ArrayList<String> getExamName(int examId) {
	
    //preparing some objects for connection 
    Statement stmt = null; 
    
	ArrayList<String> examName = new ArrayList<>();
   
	    
	String searchQuery="select * from exam where exam_id='"+examId+"'";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    while(rs.next()) {
    	examName.add(rs.getString("exam_name"));
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

return examName;
}



public static int getExamMark(int examId) {
	
    //preparing some objects for connection 
    Statement stmt = null; 
    
	int mark = 0 ;
   
	    
	String searchQuery="select * from exam where exam_id='"+examId+"'";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    while(rs.next()) {
    	mark =rs.getInt("exam_mark");
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

return mark;
}



public static Question insertQuestion(Question question ,Exam exam) {
	
    //preparing some objects for connection
	
    Statement stmt = null;    
	String questionName=question.getName();
	int exam_id = exam.getId();
   
	    
    String searchQuery="insert into question(exam_id ,question_name)"
  		  +"values(" +"'"+exam_id+"'" +","+"'"+questionName+"')";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    stmt.execute(searchQuery);
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

return question;
}



public static ArrayList<Integer> getQuestionId() {
	
    //preparing some objects for connection 
    Statement stmt = null;
    
	ArrayList<Integer> id =  new ArrayList<>();
    
    String searchQuery="select * from question";
         
    
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    
    
    while(rs.next()) {
    	id.add(rs.getInt("question_id"));
    	
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

return id;
}




public static ArrayList<String> getQuestionName() {
	
    //preparing some objects for connection 
    Statement stmt = null;
    
	ArrayList<String> name =  new ArrayList<>();
    
    String searchQuery="select * from question";
         
    
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    
    
    while(rs.next()) {
    	name.add(rs.getString("question_name"));
    	
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

return name;
}


public static ArrayList<String> getQuestionNameByExamId( int examId) {
	
    //preparing some objects for connection 
    Statement stmt = null;
    
	ArrayList<String> name =  new ArrayList<>();
    
    String searchQuery="select * from question where exam_id =" + examId +"";
         
    
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    
    
    while(rs.next()) {
    	name.add(rs.getString("question_name"));
    	
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

return name;
}


public static Answer insertAnswer(Answer answer ,Exam exam ,Question question) {
	
    //preparing some objects for connection
	
    
    
	int question_id =question.getId();
	int exam_id = exam.getId();
	String answerName =answer.getName();
	int answerCorrect = answer.isCorrect();
	
   
	    
    String searchQuery="insert into answer(exam_id ,question_id ,answer_name,answer_correct)"
  		  +"values(?,?,?,?)";
         

	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    PreparedStatement stmt=currentCon.prepareStatement(searchQuery);
    
    stmt.setInt(1, exam_id);
    stmt.setInt(2, question_id);
    stmt.setString(3, answerName);
    stmt.setInt(4, answerCorrect);
    stmt.execute();
    
    System.out.print("Insert sucess");
  
	       
  
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

return answer;
}







public static ArrayList<String> getAnswerName(int id) {
	
    //preparing some objects for connection 
    Statement stmt = null;
    
	ArrayList<String> name =  new ArrayList<>();
    
    String searchQuery="select * from answer where question_id ="+id+"";
         
    
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    
    
    while(rs.next()) {
    	name.add(rs.getString("answer_name"));
    	
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

return name;
}


// test
public static ArrayList<String> getAnswerNameByExamId(int examId) {
	
    //preparing some objects for connection 
    Statement stmt = null;
    
	ArrayList<String> name =  new ArrayList<>();
    
    String searchQuery="select * from answer where exam_id=" +examId +"";
         
    
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
    stmt=currentCon.createStatement();
    rs=stmt.executeQuery(searchQuery);
    
    
    
    while(rs.next()) {
    	name.add(rs.getString("answer_name"));
    	
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

return name;
}





}









