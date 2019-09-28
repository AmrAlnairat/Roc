package com.db_src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java_src.*;

public class AdminDAO {

	
	static Connection currentCon = null;
	static ResultSet rs = null;  
		
	
	 public static Admin login(Admin admin) {
			
	      //preparing some objects for connection 
	      Statement stmt = null;    
		
	      String email    = admin.getEmail();    
	      String password = admin.getPassword();   
		    
	      String searchQuery =
	            "select * from admin where admin_email='"
	                     + email
	                     + "' AND admin_password='"
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
	         admin.setValid(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	         
		     	
	    	 int id =              rs.getInt("admin_id");
	    	 String first_name   = rs.getString("admin_fname");
	    	 String middle_name  = rs.getString("admin_mname");
	    	 String last_name    = rs.getString("admin_lname");
	    	 String phone_number = rs.getString("admin_pnumber");
	    	
	    	 
	    	 
	    	 admin.setId(id);
	    	 admin.setFirstName(first_name);
	    	 admin.setMiddleName(middle_name);
	    	 admin.setLastName(last_name);
	    	 admin.setPhoneNumber(phone_number);
	    	
	    	 
	    	 
	         admin.setValid(true);
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

	return admin;
		
	   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
