package com.car.Model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.car.db.DBconnection;

public class UserProcessing  {
	public boolean insertUser(String name,String gender,String state,String city,String street,int zip,int birthyear,String mail,String Password) throws Exception{
		String emailmd="";
		try{
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(Password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			emailmd=sb.toString();
			int m=0;
			if(gender.equals("Male")){
				m=1;
			}
			else if(gender==""||gender==null||gender.isEmpty()){
				m=1;
			}
			else{
				m=0;
			}
			//System.out.println(name+gender+state);
			Connection con=getConnection();
			System.out.println("after");
			String insert="insert into users(fullname,gender,state,city,street,zipcode,birthyear,email,password) "
					+ "values ('"+name+"',"+m+",'"+state+"','"+city+"','"+street+"',"+zip+","+birthyear+",'"+mail+"',"+"'"+emailmd+"')";
				PreparedStatement stat=con.prepareStatement(insert);
				stat.executeUpdate();
				System.out.println(emailmd);
				return true;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	public boolean checkLogin(String email, String password) throws Exception{
		String emailmd="";
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		emailmd=sb.toString();
		System.out.println(emailmd);
		Connection con=getConnection();
		String query="select email,password from users";
		PreparedStatement stat=con.prepareStatement(query);
		ResultSet res=stat.executeQuery();
		while(res.next()){
			String mail=res.getString("email").toString();
			String pass=res.getString("password").toString();
			if(email.equals(mail)&&pass.equals(emailmd)){
				return true;
			}
		}
		
		return false;
	}
	public static Connection getConnection()throws Exception{
		Connection con;
		try{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/carpooling";
			String username="root";
			String password="";
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return con;
		}
		catch(Exception e){
			System.out.println(e.toString());
			
		}
		return null;
		
	}

}
