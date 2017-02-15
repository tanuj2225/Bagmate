package com.uncc.onlinebaggagefinder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;
import com.uncc.onlinebaggagefinder.model.Message;
import com.uncc.onlinebaggagefinder.model.Notify;
import com.uncc.onlinebaggagefinder.model.Post;
import com.uncc.onlinebaggagefinder.model.User;

public class PostDao {
	ArrayList<Post> postsList=new ArrayList<Post>();
	ArrayList<Notify> notificationsList=new ArrayList<Notify>();
	ArrayList<Message> messagesList=new ArrayList<Message>();
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi_onlinebaggagefinder","root","0304");  
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	 public ArrayList<Message> getMessages(User user){
		 Connection con=UserDao.getConnection();
		 try {
			PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from messages where receiver=? and approved=?");
		statement.setString(1,user.getEmail());
		statement.setBoolean(2,false);
		ResultSet rs=statement.executeQuery();
		 Message message;
		 while(rs.next()){
			 message=new Message();
			 	message.setMsgID(rs.getInt("msgID"));
	            message.setSender(rs.getString("sender"));
	            message.setReceiver(user.getEmail());
	            message.setMessageDate(rs.getString("messageDate"));
	            message.setRequestWeight(rs.getInt("requestWeight"));
	            message.setPostWeight(rs.getInt("postWeight"));
	            message.setPostID(rs.getInt("postId"));
	            message.setMessage(rs.getString("message"));
	            message.setApproved(false);
	            messagesList.add(message);
	        }
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messagesList;
		}
	 public int insertPost(Post post){
		 int status=0;
		 String statusMsg;
		 try{
			   Connection con=UserDao.getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into posts(name,flightNo,airlines,userId,weight,source,destination,date,datePosted,userName) values (?,?,?,?,?,?,?,?,?,?)");
			   ps.setString(1,post.getName());
			   ps.setString(2,post.getFlightNo());
			   ps.setString(3,post.getAirlines());
			   ps.setString(4,post.getUserId());
			   ps.setString(5,post.getWeight());
			   ps.setString(6,post.getSource());
			   ps.setString(7,post.getDestination());
			   ps.setString(8,post.getDoj());
			   ps.setString(9,post.getDatePosted());
			   ps.setString(10,post.getUserName());
	           status=ps.executeUpdate(); 
	           con.close(); 
			   }
		 	 catch(Exception e){
				   e.printStackTrace();
			   }
		 return status;
	 }
	 public int deletePost(int id){
		 
		 try{ 
			 Connection con=UserDao.getConnection();
			 PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from posts where id=?");
			 ps.setInt(1,id);
			 return ps.executeUpdate();
			   }
		 	 catch(Exception e){
				   e.printStackTrace();
				   
			   }
		 return 0;
	 }
	 public int sendMessage(Message message){
		 int status=0;
		 try{
			   Connection con=UserDao.getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into messages(sender,receiver,messageDate,requestWeight,postWeight,postID,approved,message) values (?,?,?,?,?,?,?,?)");
			   ps.setString(1,message.getSender());
			   ps.setString(2,message.getReceiver());
			   ps.setString(3,message.getMessageDate());
			   ps.setInt(4,message.getRequestWeight());
			   ps.setInt(5,message.getPostWeight());
			   ps.setInt(6,message.getPostID());
			   ps.setBoolean(7, message.isApproved());
			   ps.setString(8,message.getMessage());
	           status=ps.executeUpdate(); 
	           con.close(); 
			   }
		 	 catch(Exception e){
				   e.printStackTrace();
			   }
		 return status;
		 
	 }
	 public ArrayList<Post> getPosts(String email,String flag){
		 try{
			 Connection con=UserDao.getConnection();
			 PreparedStatement ps=null;
			 if(flag.equalsIgnoreCase("true")){
			 ps=(PreparedStatement) con.prepareStatement("select * from posts where userId= ?");
			 }
			 else if(flag.equalsIgnoreCase("false")){
				 ps=(PreparedStatement) con.prepareStatement("select * from posts where userId!= ?");
			 }
			 ps.setString(1,email);
			 ResultSet rs=ps.executeQuery();
			 Post post;
			 while(rs.next()){
				 post=new Post();
				 	post.setId(rs.getInt("id"));
		            post.setName(rs.getString("name"));
		            post.setFlightNo(rs.getString("flightNo"));
		            post.setAirlines(rs.getString("airlines"));
		            post.setUserId(rs.getString("userId"));
		            post.setWeight(rs.getString("weight"));
		            post.setSource(rs.getString("source"));
		            post.setDestination(rs.getString("destination"));
		            post.setDoj(rs.getString("date"));
		            post.setDatePosted(rs.getString("datePosted"));
		            post.setUserName(rs.getString("userName"));
		            postsList.add(post);
		        }
			 
		 }catch(Exception ex){ex.printStackTrace();}
		 return postsList;
	 }
	 public int onApprove(int postId,int msgId,int uWeight){
		 int status=0;
		 int vStatus=0;
		 try{
			 Connection con=UserDao.getConnection();
			 PreparedStatement pStatement=(PreparedStatement) con.prepareStatement("update messages SET approved = ? WHERE msgID = ?");
			 pStatement.setBoolean(1, true);
			 pStatement.setInt(2,msgId);
			 status=pStatement.executeUpdate();
			 if(uWeight>0){
			 PreparedStatement postStatement=(PreparedStatement) con.prepareStatement("update posts SET weight = ? WHERE id = ?");
			 postStatement.setInt(1, uWeight);
			 postStatement.setInt(2,postId);
			 vStatus=postStatement.executeUpdate();
			 }
			 else if(uWeight==0){
				 PreparedStatement postStatement=(PreparedStatement) con.prepareStatement("delete from posts WHERE id = ?");
				 postStatement.setInt(1,postId);
				 vStatus=postStatement.executeUpdate();
			 }
		 
		 }
		 catch(Exception ex){ex.printStackTrace();}
		 return vStatus+status;
	 }
	 public int onDecline(int postId,int msgId){
		 int status=0;
		 try{
			 Connection con=UserDao.getConnection();
			 PreparedStatement pStatement=(PreparedStatement) con.prepareStatement("update messages SET approved = ? WHERE msgID = ?");
			 pStatement.setBoolean(1, true);
			 pStatement.setInt(2,msgId);
			 status=pStatement.executeUpdate();
			 }
		 catch(Exception ex){ex.printStackTrace();}
		 return status;
	 }
	 public int generateNotification(Notify notify){
		 int status=0;
		 try{
			 Connection con=UserDao.getConnection();
			 PreparedStatement pStatement=(PreparedStatement) con.prepareStatement("insert into notifications(notify_msg,notified_from,notified_to,contact_details,notify_date,notification_status) values (?,?,?,?,?,?)");
			 pStatement.setString(1,notify.getNotify_msg());
			 pStatement.setString(2,notify.getNotified_from());
			 pStatement.setString(3,notify.getNotified_to());
			 pStatement.setString(4,notify.getContact_details());
			 pStatement.setString(5,notify.getNotify_date());
			 pStatement.setBoolean(6,notify.isNotification_status());
			 status=pStatement.executeUpdate();
			 }
		 catch(Exception ex){ex.printStackTrace();}
		 return status;
	 }
	 public ArrayList<Notify> getNotifications(User user){
		 Connection con=UserDao.getConnection();
		 try {
			PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from notifications where notified_to=?");
		statement.setString(1,user.getEmail());
		ResultSet rs=statement.executeQuery();
		Notify notify;
		 while(rs.next()){
			 notify=new Notify();
			 notify.setNotify_msg(rs.getString("notify_msg"));
			 notify.setNotified_from(rs.getString("notified_from"));
			 notify.setNotified_to(rs.getString("notified_to"));
			 notify.setContact_details(rs.getString("contact_details"));
			 notify.setNotify_date(rs.getString("notify_date"));
			 notify.setNotification_status(rs.getBoolean("notification_status"));
			 notificationsList.add(notify);
	        }
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notificationsList;
		 
	 } 
}
