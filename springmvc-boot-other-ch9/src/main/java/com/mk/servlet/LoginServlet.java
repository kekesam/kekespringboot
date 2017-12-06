package com.mk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
		 response.setContentType("text/html");  
         PrintWriter out = response.getWriter();  
         out.println("<html>");  
         out.println("<head>");  
         out.println("<title>Hello World</title>");  
         out.println("</head>");  
         out.println("<body>");  
         out.println("<h1>大家好，我的名字叫Servlet</h1>");  
         out.println("</body>");  
         out.println("</html>"); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
