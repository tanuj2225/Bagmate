<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BAGMATE</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/header.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/actions.js" language="javascript"></script>
<body>
<div class="header">
<div class="header-block">
<div class="user-popup">
<ul class="user-actions">

<li class="getNotifications"><span class="glyphicon glyphicon-bell"></span><span>Notifications</span><span class="count"></span></li>
<li><span class="glyphicon glyphicon-envelope"></span><span>Messages</span><span class="count"></span></li>
<li class="logout"><span class="glyphicon glyphicon-off"></span><span>Logout</span></li>
</ul>
</div>
<div class="project-name">BAGMATE</div>
<div class="user"><span class="glyphicon glyphicon-user user-icon"></span><span class="user-name">${user.getFirstName()}&nbsp${user.getLastName()}</span></div>
<div class="clear_fix">
</div>
<form method="get" action="LoginServlet" class="getPosts"></form>
<form method="get" action="GetNotifications" class="getNotify"></form>
<div class="previous-block"><button class="previousHome"><span class="glyphicon glyphicon-arrow-left"></span>Back to Home Page</button></div>
<div class="msg-number"><span>${fn:length(MessageList)}</span>messages waiting for your response</div>
<div class="clear_fix">
</div>
<div class="messagesList">
<c:if test="${fn:length(MessageList) gt 0}">
<c:forEach items="${MessageList}" var="current">
<div class="currentMsg  col-md-6 col-xs-12">
        <div class="Message">
        <div class="senderName">${current.sender}</div>
        <input type="hidden" value="${current.postID}" id="postID" />
        <input type="hidden" value="${current.msgID}" id="msgID" />
        <input type="hidden" value="${current.postWeight}" id="pWeight" />
        <input type="hidden" value="${current.requestWeight}" id="rWeight" />
        <div class="react_actions">
        <span class="decline glyphicon glyphicon-remove"></span>
        <span class="approve glyphicon glyphicon-ok"></span>
        </div>
        <div class="Message-box">
        <div class="msg-details"><span>Weight Posted by you: </span>${current.postWeight} Kg</div>
        <div class="msg-details"><span>Weight Requested: </span>${current.requestWeight} Kg</div>
       
        <div class="msg-details"><span>Message: </span>${current.message}</div>
        </div>
        </div>
        </div>
      </c:forEach>
      <div class="clear_fix"></div>
      </c:if>
      <c:if test="${fn:length(MessageList) eq 0}">
      <div class="noMessages">No Messages to Show</div>
      </c:if>
      </div>
</div>
</div>
</body>
</html>