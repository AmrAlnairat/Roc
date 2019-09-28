package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db_src.AdminDAO;
import com.db_src.StudentDAO;
import com.java_src.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		student.setPassword(request.getParameter("password"));
		
		
		Admin admin = new Admin();
		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));
		
	    
	    student = StudentDAO.login(student);
	    admin   = AdminDAO.login(admin);
	    
		if (student.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("student",student);
	          response.sendRedirect("student_page.jsp?student_id=" +student.getId());
	          
	          
	     } else if(admin.isValid()) {
	    	 
	    	  HttpSession session = request.getSession(true);	    
	          session.setAttribute("admin",admin);
	          response.sendRedirect("admin_page.jsp?admin_id=" +admin.getId());
	    	 
	    	 
	     }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
