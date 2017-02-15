package com.uncc.onlinebaggagefinder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uncc.onlinebaggagefinder.dao.PostDao;
import com.uncc.onlinebaggagefinder.model.Post;
import com.uncc.onlinebaggagefinder.model.User;

/**
 * Servlet implementation class PostingServlet
 */
@WebServlet("/PostingServlet")
public class PostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ArrayList<Post> postlist=new ArrayList<Post>();
	HttpSession session=request.getSession(); 
	 User user=(User) session.getAttribute("user");
	 PostDao dao=new PostDao();
	 
	 String flag=request.getParameter("flag");
	 postlist=dao.getPosts(user.getEmail(),flag);
	 PrintWriter out = response.getWriter();
	 String posts="";
	 String postheader="";
	 if(postlist.size()>0){
	 for(int i=0;i<postlist.size();i++){
		 Post post=new Post();
		 post=postlist.get(i);
		 if(!post.getUserId().equalsIgnoreCase(user.getEmail())){
			 postheader="<div class='postHeader col-md-12 col-xs-12'><div class='col-md-5 col-xs-8 pd0'><div class='postedUser'><span class='postedUserName'>"+post.getUserName()+"</span><input type='hidden' class='postID' value='"+post.getId()+"'><input type='hidden' class='receiver' value='"+post.getUserId()+"'><input type='hidden' class='sender' value='"+user.getEmail()+"'></div></div><div class='col-md-5 col-xs-3 pd0'><div class='postedDate'><span class='date_post_label'>Posted on:</span>"+post.getDatePosted()+"</div></div><div class='col-md-2 col-xs-4 pd0 extra-actions'><span class='glyphicon glyphicon-envelope Request_Baggage' data-toggle='tooltip' title='Request Baggage Space'></span></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";

		 }
		 else{
		 postheader="<div class='postHeader col-md-12 col-xs-12'><div class='col-md-5 col-xs-8 pd0'><div class='postedUser'><span class='postedUserName'>"+post.getUserName()+"</span><input type='hidden' class='postID' value='"+post.getId()+"'><input type='hidden' class='receiver' value='"+post.getUserId()+"'><input type='hidden' class='sender' value='"+user.getEmail()+"'></div></div><div class='col-md-5 col-xs-3 pd0'><div class='postedDate'><span class='date_post_label'>Posted on:</span>"+post.getDatePosted()+"</div></div><div class='col-md-2 col-xs-4 pd0 extra-actions'><span class='glyphicon glyphicon-trash post_remove' data-toggle='tooltip' title='Delete Post'></span></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
		
		 }String postbody="<div class='col-md-12 col-xs-12 details_block pd0'><div class='Airlines-details col-md-10 col-xs-9'><div class='Airlines-name col-md-3 col-xs-3'><div>"+post.getAirlines()+"</div><div>"+post.getFlightNo().toUpperCase()+"</div></div><div class='Route col-md-6 col-xs-7 pd0'><div class='col-md-3 col-xs-4 pd0'><span class='glyphicon glyphicon-plane plane-post'></span></div><div class='col-md-9 col-xs-8 pd0'><div class='router'>"+post.getSource()+"</div><div class='to'><span class='glyphicon glyphicon-arrow-down'></span></div><div class='router'>"+post.getDestination()+"</div></div><div class='clear_fix'></div></div><div class='Calendar col-md-3 col-xs-2 pd0'><div><span class='glyphicon glyphicon-calendar cal-icon'></span><span class='doj'>"+post.getDoj()+"</span></div><div class='dojLabel'>Date of Journey</div></div></div><div class='col-md-2 col-xs-4 weight_block'><div class='weight'>"+post.getWeight()+"</div></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
		String postMsgbody="<div class='col-md-12 col-xs-12 msg-block pd0'><span class='msg-block-user'>@"+post.getUserName()+":</span><span>"+post.getName()+"</span></div><div class='clear_fix'></div>";
		String postDIV="<div class='post col-md-12 col-xs-12 pd0'>"+postheader+postbody+postMsgbody+"</div><div class='clear_fix'></div>";
		posts=posts+postDIV;
	 }
		 out.print(posts);
	}
	 else{
		 String noPost="<div class='noPosts'>No Posts to Show</div><div class='clear_fix'></div>";
		 out.print(noPost);
	 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy hh:mm aaa");
		   //get current date time with Date()
		   Date date = new Date();

		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		 String eMail=user.getEmail();
		 String uName=user.getFirstName()+" "+user.getLastName();
	     String fno=request.getParameter("flightNo");
	     String airlines=request.getParameter("airlines");
	     String src=request.getParameter("source");
	     String destn=request.getParameter("destination");
	     String weight=request.getParameter("weight");
	     String msg=request.getParameter("msg");
	     String doj=request.getParameter("date");
	     Post post=new Post();
	     post.setAirlines(airlines);post.setSource(src);post.setDestination(destn);post.setUserId(eMail);post.setName(msg);
	     post.setFlightNo(fno);post.setWeight(weight);post.setDoj(doj);post.setDatePosted(dateFormat.format(date));post.setUserName(uName);
	     PostDao postdao=new PostDao();
	     int status=postdao.insertPost(post);
	     PrintWriter out = response.getWriter();
	     out.print("inserted succesfully");
	     
	}

}
