package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db_src.*;
import com.java_src.*;
import com.sun.org.apache.xml.internal.serialize.Printer;

/**
 * Servlet implementation class UpdateStudentInfo
 */
@WebServlet("/UpdateStudentInfo")
public class UpdateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Student student_update =(Student)session.getAttribute("student");
		
		//PrintWriter out =response.getWriter();
		//out.print(student_update.getId());
		
		
		 Student student= new Student(student_update.getId(), 
				request.getParameter("first_name"), 
				request.getParameter("middle_name"), 
				request.getParameter("last_name"), 
				request.getParameter("email"),
				request.getParameter("phone_number"));
		
		
			
		student = StudentDAO.updateProfile(student);
		
		session.setAttribute("student",student);
		response.sendRedirect("student_page.jsp?id=" +student_update.getId());
		
		
		
		
	}
	
	

}
