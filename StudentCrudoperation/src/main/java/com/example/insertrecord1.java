package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insertrecord1")
public class insertrecord1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Read all values from HTML Page
			int rollno=Integer.parseInt(request.getParameter("txtRollno"));
			String name=request.getParameter("txtName");
			Float marks=Float.parseFloat(request.getParameter("txtMarks"));
			
			//Call Connection Method
			Connection con=Dbclass.getConnection();
			//Create query
			String query="insert into Student (rollno,sname,marks) values (?,?,?)";
			//Create Statement Object
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, rollno);
			psmt.setString(2, name);
			psmt.setFloat(3, marks);
					
			//execute query
			int ans=psmt.executeUpdate();
			PrintWriter out=response.getWriter();
			if(ans>0)
				out.println("Record Inserted");
			else
				out.println("Record not inserted");
			
		}catch(Exception e) {
			e.printStackTrace();}
		}

}