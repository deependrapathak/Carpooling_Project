var x;
var y;
var z;
var a;
$(function(){
	$.post("PostServlet").done(function(exp){
			x=exp;
			$.each(exp.Message,function(i,data){
			
				var msg_data="";
				msg_data+="<div class='msg'><p class='pride'>"+data.name+"</p>";
				msg_data+=data.post+"<br><button class='like' data-postid=\""+data.postid+"\">Like</button>              <button class='comment' data-postid=\""+data.postid+"\">Comment</button></div>";
				$("#ajdiv").append(msg_data);
			})	
	
	}).fail(function(xhr,status,exception){
		console.log(1);
	})
$("#btnLogout").click(function(){
	 window.location.href="index.jsp";
});	
	$(document.body).on("click",'.comment',function(){
		var self=$(this);
		
		//,{postId:$(this).attr("data-postid")}
		$.post('CommentServlet').done(function(response){
		x=response;
		y=response.Message;
			var content="";	
		$.each(response.Message,function(uid,value){
			content+="<h4><p class='pcomment'>"+value.fullname+" has commented as:</p>"+value.comment+"</h4>";
			a=value.postid;
		})
		//a=response.Message.postid;
		//a=$(this).attr("data-postid");
		content+="<form action='InsertComment' method='post'><input type='hidden' value='"+a+"' name='txthidden'><input type='textarea' name='txtcomment' /><br><input type='submit' value='comment'/></form>"
		self.parent().append(content);
		}).fail(function(xhr,status,exception){
			console.log(1);
		})
	})
	$(document.body).on("click",'.like',function(){
		
		var self=$(this);
		self.css('background-color','blue');
	})
})
