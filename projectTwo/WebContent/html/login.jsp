<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>
		Log In
	</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		.jumbotron{background-color: #70c270}
		.bg-grey{background-color: #f6f6f6 }
	</style>
	</head>
	<body>
		<div class="container">
		<div class="jumbotron text-center">
		<img src="images/7.png" class="img-rounded" align="middle" alt="Cinque Terre" width="500px" height="300px">
		</div>
			<div class="container-fluid bg-grey">
			<form name="login" method="post" action="/projectTwo/login" class="form-horizontal">
				<div class="form-group">
				<legend>
				<H3 class="text-center"><B>WELCOME TO THE LOG-IN PAGE:</B></H3>
				</legend>
				</div>
				<div>
				
				<center><p>OOPS!!!PLEASE ENTER VALID EMAIL ID AND PASSWORD</p></center>
				</div>
				<br>
				<label class="control-label col-sm-3" for="emailId">Email ID :</label>
				<div class="col-sm-6">
					<input type="email" name="emailId" class="form-control" placeholder="Enter your Email ID" required>
				</div>
				<br>
				<br>
				<br>
				<label class="control-label col-sm-3" for="password">Password</label>
				<div class="col-sm-6">
					<input type="password" name="password" class="form-control" placeholder="Enter your Password" required>					
				</div>
				<br>	
				<br>
				<br>
				<div class="form-group">
				<div class="col-md-offset-20 col-sm- 1">
					<center><button type="submit" name="submit" class="btn btn-default">Submit</button></center>
				</div>
				
				
				<br>
				<!-- <form method="post" name="signUp" action="html/signUp"> -->
				<div class="col-sm- 6">
					<center><button name="registerPageRender" class="btn btn-default"><a href="/projectTwo/registerPageRender" media="GET">Sign Up</a></button></center>
				</div>
				<br>
				<!-- </form>
				<form> -->
				<div class="col-sm- 6">
					<center><button type="submit" name="forgotPassword" class="btn btn-default"><a href="/projectTwo/forgotPassword" media="GET">Forgot password ?</a></button></center>
				<br>
				<br>
				</div>
				</div>
				</div>
			
				</form>
				<!-- </form> -->


			</div>
		
	</body>
	</html>