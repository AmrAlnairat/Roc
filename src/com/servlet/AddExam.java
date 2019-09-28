package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db_src.FileDAO;
import com.java_src.Admin;
import com.java_src.Exam;
import com.java_src.Filee;

/**
 * Servlet implementation class AddExam
 */
@WebServlet("/AddExam")
public class AddExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String inStime =request.getParameter("start_time");
		String inEtime =request.getParameter("end_time");
		
		String strTime[] = new String[3];
		strTime=inStime.split(":");
		

		String enTime[] = new String[3];
		enTime=inEtime.split(":");
		
		
		Time starTime = new Time(Integer.parseInt(strTime[0]),Integer.parseInt(strTime[1]),Integer.parseInt(strTime[2]));
		Time endTime = new Time(Integer.parseInt(enTime[0]),Integer.parseInt(enTime[1]),Integer.parseInt(enTime[2]));
		
		
		  String inDate = request.getParameter("exam_date");
		  
		  String dat[] = new String[inDate.split("-").length]; 
		  
		  dat=inDate.split("-");
		   
		  Date date = new Date(Integer.parseInt(dat[0]) ,Integer.parseInt(dat[1]),Integer.parseInt(dat[2]));
		  
		  
		
		  String examName =request.getParameter("exam_name") ; 
		  int mark =Integer.parseInt(request.getParameter("exam_mark"));
		  
		  Exam exam = new Exam(examName,starTime,endTime,date,mark);
		  
		  FileDAO.insertExam(exam);
		  
          Filee file = new Filee();
          
          exam =file.getExamId(exam) ;
          
          file.insertQuestion(request.getParameter("file"), exam);
          file.insertAnswers(request.getParameter("file"), exam);
          
          
          HttpSession session = request.getSession(true);
          Admin admin =(Admin)session.getAttribute("admin");
          
          response.sendRedirect("admin_page.jsp?admin_id=" + admin.getId());
          
          
		  
		  
		 
		 
		
		
		
		
		
	}

}
