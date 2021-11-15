package backend;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	public void init() throws ServletException {
		
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
			if (email.isBlank() || password.isBlank()) {
				out.println("Login missing fields!");
			} else {
				out.println("Submitted login!");
			}
		}
		
		// Registration form submitted
		else if (request.getParameter("register") != null) {
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String confirm_pass = request.getParameter("confirm_pass");
			String terms = request.getParameter("terms");
			if (email.isBlank() || name.isBlank() || password.isBlank() || confirm_pass.isBlank() || terms == null) {
				out.println("Registration missing fields!");
			} else {
				out.println("Submitted registration!");
			}
		}
		
		out.close();
	}
	
	public void destroy() {
		
	}
}
