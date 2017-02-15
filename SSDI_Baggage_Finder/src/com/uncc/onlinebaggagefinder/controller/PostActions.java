package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.model.Message;

/**
 * Servlet implementation class PostActions
 */
@WebServlet("/PostActions")
public class PostActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int postID=Integer.parseInt(request.getParameter("postID"));
		
		PostDao dao=new PostDao();
		int deleteFlag=dao.deletePost(postID);
		out.print(deleteFlag);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//{"receiver":receiver,"sender":sender,"msgDate":msgDate,"postedValue":max,"requestedValue":bagrValue,"postID":postID,"messageText":msgText}
			String sender=request.getParameter("sender");
			 String receiver=request.getParameter("receiver");
			 String msgText=request.getParameter("messageText");
			 String msgDate=request.getParameter("msgDate");
			 int postedValue=Integer.parseInt(request.getParameter("postedValue"));
			 int requestedValue=Integer.parseInt(request.getParameter("requestedValue"));
			 int postID=Integer.parseInt(request.getParameter("postID"));
			 boolean approved=false;
			 Message message=new Message();
			 message.setSender(sender);message.setReceiver(receiver);message.setApproved(approved);message.setMessageDate(msgDate);message.setMessage(msgText);
			 message.setPostWeight(postedValue);message.setRequestWeight(requestedValue);message.setPostID(postID);
			 PostDao dao=new PostDao();
			 int status=dao.sendMessage(message);
			 PrintWriter out = response.getWriter();
			 out.print(status);
	}

}
