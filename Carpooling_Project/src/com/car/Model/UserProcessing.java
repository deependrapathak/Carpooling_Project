package com.car.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.car.db.DBconnection;

public class UserProcessing  {
	public void insertUser(String name,String gender,String state,String city,String street,int zip,int birthyear,String mail,String Password) throws Exception{
		try{
			int m=0;
			if(gender.equals("Male")){
				m=1;
			}
			System.out.println(name+gender+state);
			Connection con=DBconnection.getConnection();
			System.out.println("after");
			String insert="insert into users(fullname,gender,state,city,street,zipcode,birthyear,email,password) values ('"+name+"',"+m+",'"+state+"','"+city+"','"+street+"',"+zip+","+birthyear+",'"+mail+"','"+Password+"')";
				PreparedStatement stat=con.prepareStatement(insert);
				stat.executeUpdate();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		
	}

}
