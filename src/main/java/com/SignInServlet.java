package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("userId"));
		String password=request.getParameter("userPass");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		SignInDAOImpl signin=new SignInDAOImpl();
		try {
			if(signin.login(id, password))
				response.sendRedirect("tweet.html");
			else
				out.println("Sign In Failed !");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("Something went wrong");
			e.printStackTrace();
			
		}
	}

}
