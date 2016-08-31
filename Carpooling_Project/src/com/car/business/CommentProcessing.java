package com.car.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.car.dto.DBconnection;
import com.car.model.CommentObject;

public class CommentProcessing {
public ArrayList<String> getMessage() throws SQLException, Exception{
	ArrayList comObject=new ArrayList();
	PreparedStatement ps=DBconnection.getConnection().prepareStatement("select * from comments;");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		CommentObject com=new CommentObject();
		com.setCommentid(Integer.parseInt(rs.getString("commentid")));
		com.setUserid(Integer.parseInt(rs.getString("userid")));
		com.setPostid(Integer.parseInt(rs.getString("postid")));
		com.setComment(rs.getString("comment"));
		com.setDatecreated(rs.getString("datecreated"));
		com.setDateupdated(rs.getString("dateupdated"));
		comObject.add(com);
	}
	
		
	return comObject;
} 
}
