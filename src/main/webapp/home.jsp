<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://kit.fontawesome.com/4b6d728af0.js"></script>
    <link rel="stylesheet" href="style.css">
    <title>SalEats</title>
  </head>
  <body>
  	<header>
  		<nav>
  			<a href="home.jsp" class="no-style" id="logo">SalEats!</a>
  			<span id="buttons">
  			<%
  				if (null != request.getAttribute("loginSuccess")) {
		        	out.println("<a href=\"home.jsp\" class=\"no-style\" id=\"home\">Home</a>");
		   		} else {
		        	out.println("<a href=\"home.jsp\" class=\"no-style\" id=\"home\">Home</a>");
		        	out.println("<a href=\"login.jsp\" class=\"no-style\">Login / Register</a>");
		    	}
		  	%>
  			</span>
  		</nav>
  	</header>
  	<main>
  		<img id="banner" src="images/banner.jpg">
  		<div>
	  		<form>
	  			<div class="form-container">
	  				<div class="column">
				  		<input type="text" placeholder="Restaurant Name" name="restaurant" class="textbox"><br/>
				  		<input type="text" placeholder="Location" name="location" class="textbox">
			  		</div>
			  		<div class="column">
			  			<div>
				  			<button type="submit" id="search_button">
							    <i class="fas fa-search"></i>
							</button>
						</div>
						<div class="radio-buttons-container">
							<div>
					            <label class="radio-element">
					              <input type="radio" value="Best Match" name="search_terms" />
					              Best Match
					            </label>
					            <br/>
					            <label class="radio-element">
					              <input type="radio" value="Rating" name="search_terms" />
					              Rating
					            </label>
					        </div>
				            <div>
					            <label class="radio-element">
					              <input type="radio" value="Review Count" name="search_terms" />
					              Review Count
					            </label>
					            <br/>
					            <label class="radio-element">
					              <input type="radio" value="Distance" name="search_terms" />
					              Distance
					            </label>
				            </div>
						</div>
					</div>
				</div>
	  		</form>
  		</div>
  	</main>
  	<footer>
  		<p>&copy; 2021 All Rights Reserved.</p>
  	</footer>
  </body>
</html>