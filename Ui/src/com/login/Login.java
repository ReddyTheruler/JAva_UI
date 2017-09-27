package com.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        String email = request.getParameter("email");
	        String pass = request.getParameter("pass");
	        Validate vald=new Validate();
	        if( vald.checkUser(email, pass))
	        {
	            RequestDispatcher rs = request.getRequestDispatcher("dashboard.html");
	            rs.forward(request, response);
	            out.println("Welcome user");
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
	           rs.include(request, response);
	        }      
	}
}