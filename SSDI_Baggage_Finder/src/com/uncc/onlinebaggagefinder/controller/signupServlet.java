package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.dao.UserDao;
import com.uncc.onlinebaggagefinder.model.Message;
import com.uncc.onlinebaggagefinder.model.User;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	  User user;
      HttpSession session;
      ArrayList<Message> mList;
	private static final long serialVersionUID = 1L;
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	     //PrintWriter out=response.getWriter();
	     String fName=request.getParameter("fName");  
	     String lName=request.getParameter("lName");
	     String email=request.getParameter("email");
	     String cCode=request.getParameter("cCode");
	     String phoneNo=request.getParameter("phoneNo");
	     String address=request.getParameter("address");
	     String passportNo=request.getParameter("passportNo");
	     String password=request.getParameter("password");
	     HttpSession session=request.getSession();  
	     User user=new User(fName,lName,email,address,password,cCode,phoneNo,passportNo);
	     UserDao dao=new UserDao();
	     int status=dao.insertRecord(user);
	     if(status>0){
	    	 session.setAttribute("user",user);
	    	 request.setAttribute("userName",user.getFirstName()+" "+user.getLastName());
	    	 request.getRequestDispatcher("account.jsp").forward(request, response);
	     }
	     else{
	    	 request.getRequestDispatcher("home.jsp").forward(request, response);
	     }
	}

}
