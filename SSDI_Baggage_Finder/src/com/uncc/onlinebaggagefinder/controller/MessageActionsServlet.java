package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.model.Notify;
import com.uncc.onlinebaggagefinder.model.User;

/**
 * Servlet implementation class MessageActionsServlet
 */
@WebServlet("/MessageActionsServlet")
public class MessageActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageActionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE, d MMM yyyy hh:mm aaa");
	     String dateLabel = DATE_FORMAT.format(date);
		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		PostDao dao=new PostDao();
		Notify notify=new Notify();
		int postID=Integer.parseInt(request.getParameter("postID"));
		int msgID=Integer.parseInt(request.getParameter("msgID"));
		String receiver=request.getParameter("receiver");
		String contact="Please call/message on: "+user.getCountry_code()+"-"+user.getPhone_no()+" or Email me at: "+user.getEmail();
		String sender=user.getFirstName()+" "+user.getLastName();
		int declineStatus=dao.onDecline(postID, msgID);
		if(declineStatus>0){
			String notify_msg= sender+" has declined your baggage request,he/she might be out of space.Sorry,Please try Later.";
			notify.setContact_details(contact);
			notify.setNotified_from(sender);
			notify.setNotified_to(receiver);
			notify.setNotify_date(dateLabel);
			notify.setNotify_msg(notify_msg);
			notify.setNotification_status(false);
			dao.generateNotification(notify);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE, d MMM yyyy hh:mm aaa");
	     String dateLabel = DATE_FORMAT.format(date);
		HttpSession session=request.getSession(); 
		User user=(User) session.getAttribute("user");
		PostDao dao=new PostDao();
		Notify notify=new Notify();
		int postID=Integer.parseInt(request.getParameter("postID"));
		int msgID=Integer.parseInt(request.getParameter("msgID"));
		int pWeight=Integer.parseInt(request.getParameter("pWeight"));
		int rWeight=Integer.parseInt(request.getParameter("rWeight"));
		int uweight=pWeight-rWeight;
		String receiver=request.getParameter("receiver");
		String contact="Please call/message on: "+user.getCountry_code()+"-"+user.getPhone_no()+" or Email me at: "+user.getEmail();
		String sender=user.getFirstName()+" "+user.getLastName();
		int vStatus=dao.onApprove(postID, msgID,uweight);
		if(vStatus>1){
			String notify_msg= sender+" has accepted your baggage request,you can contact "+ sender +" using the contact details appended below.";
			notify.setContact_details(contact);
			notify.setNotified_from(sender);
			notify.setNotified_to(receiver);
			notify.setNotify_date(dateLabel);
			notify.setNotify_msg(notify_msg);
			notify.setNotification_status(true);
			dao.generateNotification(notify);
		}

	}

}
