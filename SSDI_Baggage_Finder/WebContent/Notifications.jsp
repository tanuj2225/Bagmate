<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BAGMATE</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/header.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/jquery-ui.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/actions.js" language="javascript"></script>
</head>
<body>
<div class="header">
<div class="header-block">
<div class="user-popup">
<form action="MessageServlet" class="getMessagesForm" style="display:none" method="get">
</form>
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
<div class="clear_fix"></div>
<form method="get" action="GetNotifications" class="getNotify"></form>
<!-- Hey Body starts here -->
<form method="get" action="LoginServlet" class="getPosts"></form>
<div class="body-start">
<div class="previous-block"><button class="previousHome"><span class="glyphicon glyphicon-arrow-left"></span>Back to Home Page</button></div>
<div class="clear_fix"></div>
<div class="col-md-7 col-xs-12 notificationsList">
<c:forEach items="${NotificationsList}" var="current">
<c:if test="${current.notification_status eq true}">
<div class="notification">
<div class="notify_head">
<div class="notify-partA"><span class="glyphicon glyphicon-bell"></span></div>
<div class="notify-partB"><div class="notify-from">${current.notified_from}</div><div class="notfiy-date">${current.notify_date}</div></div>
<div class="clear_fix"></div>
</div>
<div class="notify_msg">
${current.notify_msg}
</div>
<div class="notify_contact_details">
${current.contact_details}
</div>
</div>
</c:if>
<c:if test="${current.notification_status eq false}">
<div class="notification">
<div class="notify_head">
<div class="notify-partA"><span class="glyphicon glyphicon-bell"></span></div>
<div class="notify-partB"><div class="notify-from">${current.notified_from}</div><div class="notfiy-date">${current.notify_date}</div></div>
<div class="clear_fix"></div>
</div>
<div class="notify_msg">
${current.notify_msg}
</div>
</div>
</c:if>
      </c:forEach>
      <div class="clear_fix"></div>
      </div>
<div class="col-md-5 col-xs-12 adsCarousel">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="images/american.png" alt="Chania">
    </div>

    <div class="item">
      <img src="images/british.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="images/qatar.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="images/turkish.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</div>
</body>
</html>