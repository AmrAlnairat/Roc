package com.java_src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import com.java_src.*;
import com.sun.glass.ui.Size;
import com.db_src.*;


public class Filee {
	
	
	private String filePath ;
	
	
	
	
	
	
	public Filee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	public Filee(String filePath) {
		super();
		this.filePath = filePath;
	}







	public String ReadFile(String filePath)
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	    {
	 
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null)
	        {
	            contentBuilder.append(sCurrentLine).append("\n");
	        }
	        br.close();
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return contentBuilder.toString();
	}
	
	
	public Exam insertExamName(Exam exam) {
		
		 exam=FileDAO.insertExam(exam);
		 
		 return exam;
	}
	
	
	public Exam getExamId(Exam exam) {
		
       exam=FileDAO.getExamId(exam);
		 return exam;
	}
	
	// insert question name with exam_id
	public void insertQuestion(String filePath ,Exam exam) {
		
		String file = ReadFile(filePath);
		String[] examFile = file.split(",");
		
		int numOfQuestion = Integer.parseInt(examFile[0]);
		
		 Question[] qw = new Question[numOfQuestion*5];
		 for(int i =1 ; i<5*numOfQuestion;i=i+5) {
			 qw[i]= new Question(examFile[i]);
			 qw[i]=FileDAO.insertQuestion(qw[i], exam);
		 }
		
		
	}
	
	
	public ArrayList<Integer> getQuestionId(){
		
		ArrayList<Integer> id =FileDAO.getQuestionId();
		return id;
		
	}
	
	
	
	public ArrayList<String> getAnswers(String filePath){
		  ArrayList<String> answers =new ArrayList<>();
		  String file = ReadFile(filePath);
			String[] examFile = file.split(",");
			
			int numOfQuestion = Integer.parseInt(examFile[0]);
			 int counter = 0;
			 for(int i =2 ; i<(numOfQuestion*5)+1 ;i++) {
				 counter++;
				 if(counter>4) {
					 i=i+1;
					 counter=1;
				 }
				
				 answers.add(examFile[i]); 
			 }
			 
			 return answers;
	}
	
	
	public void insertAnswers(String filePath ,Exam exam) {
		

		  //insert answers 
		 Answer[] answer =new Answer[getAnswers(filePath).size()];
		 Question[] qw = new Question[getQuestionId().size()];
		   int correct=0; 
		   int count =  0 ;
		   int countt = 0;
		   
		   		for(int i = 0 ;i<getAnswers(filePath).size() ;i++) {
		             
		   			if(count>3) {
		            	 countt++;
		            	 count =0;
		            	 correct =1;
		             }
		   			
		   			if (count==0){
		   			correct =1;
		   			}
		   			System.out.println("  Exam_id " +getExamId(exam).getId() +"  Qu_id "+getQuestionId().get(countt) +
		   					"  Answer_nname " +getAnswers(filePath).get(i) +"  is correct  "+correct );
		   			answer[i]=new Answer(getAnswers(filePath).get(i) , correct);
		   			qw[countt]=new Question();
		   			qw[countt].setId(getQuestionId().get(countt));
		   			
		   			FileDAO.insertAnswer(answer[i], exam, qw[countt]);
		   			++count;
		   			correct = 0;
		   			
		   			
		  }
		   		
		   		
		   		
		   			 
		
		
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	

	
	
	
		    
		 
		 
		 
		 
		 
		
		 
		
		 
		 
		 
			
			
			
		  
		 
		 
		
		 
		 
         
		 
		 
		 
		 
		 
		      
		
		
		
	}
	
	



