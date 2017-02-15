package com.uncc.onlinebaggagefinder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.uncc.onlinebaggagefinder.model.User;
 
public class UserDao {
	String statusMsg="";
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi_onlinebaggagefinder","root","0304");  
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	   public User login_check(String email,String password){
		   User user=new User();
		   try{
			   Connection con=UserDao.getConnection();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from user where email=? and password=?");
			   statement.setString(1,email);  
			   statement.setString(2,password);  
		       ResultSet rs=statement.executeQuery();  
		        while(rs.next()){
		            user.setFirstName(rs.getString("firstName"));
		            user.setLastName(rs.getString("lastName"));
		            user.setEmail(rs.getString("email"));
		            user.setCountry_code(rs.getString("countrycode"));
		            user.setPhone_no(rs.getString("phone"));
		            user.setPassport_no(rs.getString("passport"));
		            user.setAddress(rs.getString("address"));
		            user.setPassword(rs.getString("password"));
		            statusMsg="Success";
					user.setStatusMsg(statusMsg);
					
		        }  
		   }catch(Exception ex){
			   ex.printStackTrace();
			   statusMsg="Error";
			   user.setStatusMsg(statusMsg);
		   }
		   return user;
	   }
	   public int insertRecord(User user){
		   int status=0;
		   try{
		   Connection con=UserDao.getConnection();
		   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into user(firstName,lastName,email,countrycode,phone,passport,address,password) values (?,?,?,?,?,?,?,?)");
		   ps.setString(1,user.getFirstName());
		   ps.setString(2,user.getLastName());
		   ps.setString(3,user.getEmail());
		   ps.setString(4,"+1");
		   ps.setString(5,user.getPhone_no());
		   ps.setString(6,user.getPassport_no());
		   ps.setString(7,user.getAddress());
		   ps.setString(8,user.getPassword());
           status=ps.executeUpdate(); 
           statusMsg="Success";
           user.setStatusMsg(statusMsg);
           con.close(); 
		   }
		   catch(Exception ex){
			   ex.printStackTrace();
			   statusMsg="Error";
		   user.setStatusMsg(statusMsg);}
		   return status;
	   }
}
