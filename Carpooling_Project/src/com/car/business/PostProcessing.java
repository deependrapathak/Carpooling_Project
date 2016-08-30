package com.car.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.car.dto.DBconnection;

public class PostProcessing {
	public  ArrayList<String> show() throws Exception{
		try{
			Connection con=DBconnection.getConnection();
			PreparedStatement statement=con.prepareStatement("Select post from posts");
			ResultSet result=statement.executeQuery();
			ArrayList<String> str=new ArrayList<String>();
			while(result.next()){
				System.out.print(result.getString("post"));
				System.out.println();
				str.add(result.getString("post"));
				
			}
			return str;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			
		}
		return null;
	}
}
