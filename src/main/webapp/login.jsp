<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="google-signin-client_id" content="781478761130-14fgtrr77tni1vtovttoih4dkjja3elu.apps.googleusercontent.com.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://kit.fontawesome.com/4b6d728af0.js"></script>
    <link rel="stylesheet" href="style.css">
    <title>SalEats</title>
  </head>
  <body>
  	<header>
  		<nav>
  			<a href="home.html" class="no-style" id="logo">SalEats!</a>
  			<span id="buttons">  			
	  			<a href="home.html" class="no-style" id="home">Home</a>
		  		<a href="login.jsp" class="no-style">Login / Register</a>
  			</span>
  		</nav>
  	</header>
  	<main>
  		<div class="login-form-container">
  			<div>
	  			<form class="login-form" action="auth" method="POST">
	  				<div>
		  				<h1 class="form-header">Login</h1>
			  			<%
						    if (null != request.getAttribute("loginError")) {
						        out.println(request.getAttribute("loginError"));
						    } else {
						    	out.println("<p class=\"error-message\" style=\"visibility: hidden;\">invisible</p>");
						    }
						%>
		  			</div>
	  				<label>Email</label>
	  				<input type="text" class="textbox" name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
	  				<label>Password</label>
	  				<input type="password" class="textbox" name="password" required pattern="\S(.*\S)?">
	  				<button type="submit" name="login" class="login-button"><i class="fas fa-sign-in-alt"></i>Sign In</button>
	  			</form>
	  			<p id="divider"></p>
	  			<button type="submit" id="google" class="login-button"><i class="fab fa-google"></i>Sign In with Google</button>
  			</div>
  			<form class="login-form" action="auth" method="POST">
	  				<div>
		  				<h1 class="form-header">Register</h1>
			  			<%
						    if (null != request.getAttribute("registerError")) {
						    	out.println(request.getAttribute("registerError"));
						    } else {
						    	out.println("<p class=\"error-message\" style=\"visibility: hidden;\">invisible</p>");
						    }
						%>
		  			</div>
  				<label>Email</label>
  				<input type="text" class="textbox" name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
  				<label>Name</label>
  				<input type="text" class="textbox" name="name" required pattern="\S(.*\S)?">
  				<label>Password</label>
  				<input type="password" class="textbox" name="password" required pattern="\S(.*\S)?">
  				<label>Confirm Password</label>
  				<input type="password" class="textbox" name="confirm_pass" required pattern="\S(.*\S)?">
  				<div>
	  				<label class="terms">
	  					<input type="checkbox" name="terms" class="terms" required>
	  					I have read and agree to all terms and conditions of SalEats.
	  				</label>
  				</div>
  				<button type="submit" name="register" class="login-button"><i class="fas fa-user-plus"></i>Create Account</button>
  			</form>
  		</div>
  	</main>
  	<footer>
  		<p>&copy; 2021 All Rights Reserved.</p>
  	</footer>
  </body>
</html>