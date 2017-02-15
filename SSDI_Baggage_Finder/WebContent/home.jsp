<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<title>BAGMATE-online Baggage Mate finder</title>

<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/actions.js" language="javascript"></script>
<script type="text/javascript">
function validateForm(formContainer){
	var flag=0;
	$(formContainer).find("input").each(function(){
		if($(this).val()==null || $(this).val()==""){
			flag=flag+1;
		}
		
	});
	if(flag>0){
		$(".error").show();
		$(document).scrollTop(0);
		return false;
	}
	else{
		return true;
	}
}
</script>
</head>
<body>
<div class="background">
<div class="back-text">BAGMATE</div>
<div class="back-text-tagline">Online Baggage Mate Finder</div>
</div>
<div class="error"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span><span class="error_text">Enter all the fields</span></div>
<div class="title-holder">
<div class="title-img">
</div>
</div>
<div class="authentication">

<div class="login">
<form action="LoginServlet" onsubmit="return validateForm(this)" method="post">
<input type="text" placeholder="Email" name="eLmail">
<input type="password" placeholder="Password" name="ePassword">
<a href="#" class="signup">New to this site? Create new account</a>
<input type="submit" value="Login" class="loginBtn">
</form>
</div>
<div class="signup-block">
<form action="signupServlet" onsubmit="return validateForm(this)" method="post">
<input type="text" placeholder="Firstname" name="fName" >
<input type="text" placeholder="Lastname" name="lName">
<input type="text" placeholder="Email" name="email">
<input type="text" placeholder="Code" class="countrycode" name="cCode">
<input type="text" placeholder="Phone No" class="phoneno" name="phoneNo">
<input type="text" placeholder="Address" name="address">
<input type="text" placeholder="Passport No" name="passportNo">
<input type="password" placeholder="Password" name="password">
<input type="password" placeholder="Repeat Password">

<a href="#" class="goLogin">Already have a account? Login</a>
<input type="submit" value="Create Account" class="signUpBtn">
</form>
</div>
</div>
</body>
</html>