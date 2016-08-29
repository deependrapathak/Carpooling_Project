package com.car.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import com.car.db.DBconnection;

public class UserProcessing  {
	public void insertUser(String name,String gender,String state,String city,String street,int zip,int birthyear,String mail,String Password) throws Exception{
		try{
			int m=0;
			if(gender.equals("Male")){
				m=1;
			}
			System.out.println(name+gender+state);
			Connection con=getConnection();
			System.out.println("after");
			String insert="insert into users(fullname,gender,state,city,street,zipcode,birthyear,email,password) "
					+ "values ('"+name+"',"+m+",'"+state+"','"+city+"','"+street+"',"+zip+","+birthyear+",'"+mail+"',"+"md5('"+Password+"'))";
				PreparedStatement stat=con.prepareStatement(insert);
				stat.executeUpdate();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		
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
