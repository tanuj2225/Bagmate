<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,com.uncc.onlinebaggagefinder.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/header.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/actions.js" language="javascript"></script>
<script src="js/getPosts.js" language="javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BAGMATE</title>
</head>
<body>
<div class="header">
<div class="header-block">
<div class="user-popup">
<form action="MessageServlet" class="getMessagesForm" style="display:none" method="get">
</form>
<form method="get" action="GetNotifications" class="getNotify"></form>
<ul class="user-actions">

<li class="getNotifications"><span class="glyphicon glyphicon-bell"></span><span>Notifications</span><span class="count"></span></li>
<li class="getMessages"><span class="glyphicon glyphicon-envelope"></span><span>Messages</span><span class="count"></span></li>
<li class="logout"><span class="glyphicon glyphicon-off"></span><span>Logout</span></li>
</ul>
</div>
<div class="project-name">BAGMATE</div>
<div class="user"><span class="glyphicon glyphicon-user user-icon"></span><span class="user-name">${user.getFirstName()}&nbsp${user.getLastName()}</span></div>
<div class="clear_fix">
</div>

</div>
</div>

<!-- header end -->
<!-- body start -->

<div class="body-page">
<div class="message_sent">
<span>Message sent</span><span class="glyphicon glyphicon-ok"></span>
</div>
<div class="pop-mask"></div>
<div class="pop-up requesting-bagpopper">
<div class="close_popup"><span class="glyphicon glyphicon-remove"></span>
</div>
<div class="messagePoster">
<div class="flight-details-poster col-md-12 col-xs-12"></div>
<div class="clear_fix"></div>
<div class="weight-inpopup">
<div class="weight-label">Available weight:</div>
<div class="weightAvailable"></div>
<div class="clear_fix"></div>
<div class="requestWeight">
<span class="weight-label mt10">Request Baggage Space:</span>
<input type="number" id="rWeight" placeholder="Enter Baggage Space">
<span class="weight-label mt10 ml20">Message BAGMATE:</span>
<textarea rows="5" placeholder="Type your message here..." name="RequestMessage" id="RequestMessage" class="ml20"></textarea>
</div>
<div class="error_weight">Requested baggage weight should not exceed posted weight</div>
<div class="clear_fix"></div>
</div>
<button class="sendBtn">Send</button>
<div class="clear_fix"></div>
</div>
</div>
<div class="Filters">
<div class="my-posts"><span class="glyphicon glyphicon-refresh refresh_icon"></span><span>My Posts</span></div>
<div class="other-posts"><span class="glyphicon glyphicon-refresh refresh_icon"></span><span>Other Users Posts</span></div>
</div>
<div class="clear_fix"></div>
<div class="col-md-12 col-xs-12 pd0">
<div class="col-md-4 col-xs-12 pdl0">

<div class="make-post">

<form action="#" onsubmit="return validateForm(this)" method="post" name="post_block" class="post_block">
<div class="post-label">User Name</div>
<input type="text" name="UserMail" value="${user.getFirstName()} ${user.getLastName()}" disabled="disabled">
<div class="post-label">Flight Details</div>

<input type="text" placeholder="Airlines" name="airlines" id="airlines">
<input type="text" placeholder="Source" name="source" class="airport">
<input type="text" placeholder="Destination" name="destination" class="airport">
<input type="text" placeholder="Flight Number" name="flightNo">
<input type="text" placeholder="Date of Journey" name="date" id="DOJ">
<div class="post-label">Baggage Details</div>
<input type="number" placeholder="Baggage Weight Available (kgs)" name="weight" id="bagWeight">
<textarea rows="5" placeholder="Tell your friends something..." name="msg" id="messageArea"></textarea>
<input type="submit" value="Post" class="postbtn" id="postBTN" >
<span class="glyphicon glyphicon-send post-icon"></span>
</form>
<button class="clear-btn">Clear</button>
<span class="glyphicon glyphicon-remove clear_icon"></span>
</div></div>
<div class="col-md-8 col-xs-12 pdr0">
<div class="posts">
<div class="loader"></div>
</div>
</div>
<div class="clear_fix"></div>
</div>
<div class="clear_fix"></div>
</div>
</body>
</html>