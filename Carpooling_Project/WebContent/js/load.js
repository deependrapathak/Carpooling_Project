var x;
var y;
var z;
$(function(){
	$.post("PostServlet").done(function(exp){
			x=exp;
			$.each(exp.Message,function(i,data){
				y=data;
				z=data.name;
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
		$.post('CommentServlet',{postId:$(this).attr("data-postid")}).done(function(response){
		var content="";	
		$.each(response.Message,function(uid,value){
			content+="<h4><p class='pcomment'>"+value.fullname+" has commented as:</p>"+value.comment+"</h4>";
		})
		content+="<form action='' method=''>"+"<input type='textarea' /><br><input type='submit' value='comment'/></form>"
		self.parent().append(content);
		}).fail(function(xhr,status,exception){
			console.log(1);
		})
	})
	$(".like").on("click",function(){
		$(this).css('background-color','blue');
	})
})
