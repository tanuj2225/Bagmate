package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.model.Message;
import com.uncc.onlinebaggagefinder.model.Notify;
import com.uncc.onlinebaggagefinder.model.User;

/**
 * Servlet implementation class GetNotifications
 */
@WebServlet("/GetNotifications")
public class GetNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Notify> nList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		nList=new ArrayList<Notify>();
		HttpSession session=request.getSession(); 
		User user=(User) session.getAttribute("user");
		PostDao dao=new PostDao();
		nList=dao.getNotifications(user);
		request.setAttribute("NotificationsList", nList);
		request.getRequestDispatcher("Notifications.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
