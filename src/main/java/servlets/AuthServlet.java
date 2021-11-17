package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Pattern;

import data.Database;
import data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles user authentication for login and registration.
 * @author Thomas Peters
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7507777331673090255L;
	private Database db;
	
	public void init() throws ServletException {
		db = new Database();
	}
	
	/**
	 * Retrieves sensitive data from authentication form.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Login form submitted
		if (request.getParameter("login") != null) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			// Server side validation
			String errorMessage = null;
			if (!validEmail(email)) {
				errorMessage = "*You must enter a valid email address.";
			} else if (password.isBlank()) {
				errorMessage = "*You must enter a password.";
			} else if (!db.validate(email, password)) {
				errorMessage = "*Invalid email and password.";
			} 
			
			if (errorMessage != null) {
				request.setAttribute("loginError", "<p class=\"error-message\">" + errorMessage + "</p>");
	            request.getRequestDispatcher("/login.jsp").forward(request, response); 
			} else {                                     
	            request.getRequestDispatcher("/home.jsp").forward(request, response); 
			}	
		}
		
		// Registration form submitted
		else if (request.getParameter("register") != null) {
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String confirm_pass = request.getParameter("confirm_pass");
			String terms = request.getParameter("terms");
			
			// Server side validation
			String errorMessage = null;
			if (!validEmail(email)) {
				errorMessage = "*You must enter a valid email address.";
			} else if (name.isBlank()) {
				errorMessage = "*You must enter a name.";
			} else if (password.isBlank()) {
				errorMessage = "*You must enter a password.";
			} else if (!password.equals(confirm_pass)) {
				errorMessage = "*The passwords you entered do not match.";
			} else if (terms == null) {
				errorMessage = "*You must agree to the terms of service.";
			} else {
				try { db.registerUser(new User(email, name, password));
				} catch (SQLIntegrityConstraintViolationException e) {
					errorMessage = "*That email address is already in use.";
				}
			}
			
			if (errorMessage != null) {
				request.setAttribute("registerError", "<p class=\"error-message\">" + errorMessage + "</p>");
	            request.getRequestDispatcher("/login.jsp").forward(request, response); 
			} else {
				//Register user to database
				request.getRequestDispatcher("/home.jsp").forward(request, response); 
			}
		}
		
		out.close();
	}
	
	private boolean validEmail(String email) {
		if (email.isBlank()) { return false; }
		Pattern zipPattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
	    return zipPattern.matcher(email).matches();
	}
}
