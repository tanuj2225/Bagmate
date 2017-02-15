package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.dao.UserDao;
import com.uncc.onlinebaggagefinder.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("user");
	    request.getRequestDispatcher("account.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email=request.getParameter("eLmail");
		 String password=request.getParameter("ePassword");
		 UserDao dao=new UserDao();
		 User user=dao.login_check(email, password);
		 if(user.getStatusMsg().equalsIgnoreCase("Success")){
			   session.setAttribute("user", user);
		       request.getRequestDispatcher("account.jsp").forward(request, response);
		 }
		 else if(user.getStatusMsg().equalsIgnoreCase("Error")){
			   request.getRequestDispatcher("home.jsp").forward(request, response);
		 }
	}

}
