package com.car.business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.car.dto.DBconnection;


public class PostProcessing {
	int count=0;
	
	public  ArrayList<String> show() throws Exception{
		try{
			
			Connection con=DBconnection.getConnection();
			PreparedStatement statement=con.prepareStatement("Select post from posts");
			ResultSet result=statement.executeQuery();
			ArrayList<String> str=new ArrayList<String>();
			FileWriter writer=fileWriter();
			while(result.next()){
				System.out.print(result.getString("post"));
				System.out.println();
				str.add(result.getString("post"));
				JSONObject obj=new JSONObject();
				//JSONArray arr=new JSONArray();
				//arr.add(result.getString("post"));
				obj.put("post", result.getString("post"));
				try{
					writer.write(obj.toString());
					
				}
				catch(IOException ex){
					System.out.println(ex.toString());
				}
				
			}
			writer.flush();
			writer.close();
			return str;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			
		}
		return null;
	}
	public static FileWriter fileWriter() throws IOException{
		File file=new File("z:\\test.json");
		file.createNewFile();
		FileWriter writer=new FileWriter("z:\\test.json");
		return writer;
	}
}
