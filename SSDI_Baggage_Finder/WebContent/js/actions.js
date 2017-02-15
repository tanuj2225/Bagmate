$(document).ready(function(){
	
$(".signup").click(function(){
$(".login").toggle();
$(".signup-block").toggle();
$(".background").addClass("extend-back");
$(".error").hide();
});

$(".goLogin").click(function(){
$(".login").toggle();
$(".signup-block").toggle();
$(".background").removeClass("extend-back");
$(".error").hide();
});
$(".user").click(function(){
	$(".user-popup").toggle();
});
$(".getMessages").click(function(){
	console.log("Entered into getmessages ")
$(".getMessagesForm").submit();
});
$(".decline").click(function(){
	var element=$(this).parents(".Message");
	var postID=$(this).parents(".Message").find("#postID").val();
	var receiver=$(this).parents(".Message").find(".senderName").html();
	var msgID=$(this).parents(".Message").find("#msgID").val();
	var msgData={"postID":postID,"msgID":msgID,"receiver":receiver};
	$.ajax({
            url:'MessageActionsServlet',
            type:'get',
            data:msgData,
            cache:false,
            success:function(data){
            	$(element).html("<div class='notification_success'>Decline notification sent to "+receiver+" <span class='glyphicon glyphicon-ok'></span></div>");
            },
            error:function(){
              
            }
         });
})
$(".approve").click(function(){
	var element=$(this).parents(".Message");
	var postID=$(this).parents(".Message").find("#postID").val();
	var receiver=$(this).parents(".Message").find(".senderName").html();
	var msgID=$(this).parents(".Message").find("#msgID").val();
	var pWeight=$(this).parents(".Message").find("#pWeight").val();
	var rWeight=$(this).parents(".Message").find("#rWeight").val();
	var msgData={"postID":postID,"msgID":msgID,"receiver":receiver,"pWeight":pWeight,"rWeight":rWeight};
	$.ajax({
            url:'MessageActionsServlet',
            type:'post',
            data:msgData,
            cache:false,
            success:function(data){
            	$(element).html("<div class='notification_success'>Acceptance notification sent to "+receiver+" <span class='glyphicon glyphicon-ok'></span></div>");
            },
            error:function(){
              
            }
         });
})
$(".logout").click(function(){
		$.ajax({
            url:'LogoutServlet',
            type:'get',
            cache:false,
            success:function(data){
            	var successUrl = "home.jsp"; // might be a good idea to return this URL in the successful AJAX call
                window.location.href = successUrl;
            },
            error:function(){
              alert('error');
            }
         });
	});
$(".previousHome").click(function(){
$(".getPosts").submit();
});
$(".getNotifications").click(function(){
	console.log("Entered into getmessages ")
$(".getNotify").submit();
});
});