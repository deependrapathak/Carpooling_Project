var x;
$(function(){
	$.post("PostServlet").done(function(exp){
			x=exp;
			$.each(exp.Message,function(i,data){
				var msg_data="";
				msg_data+="<div class='msg'><p class='pride'>Offering Ride share</p>";
				msg_data+=data.post+"</div>";
				$("#ajdiv").append(msg_data);
			})	
	
	}).fail(function(xhr,status,exception){
		console.log(1);
	})
$("#btnLogout").click(function(){
	 window.location.href="index.jsp";
});	
})
