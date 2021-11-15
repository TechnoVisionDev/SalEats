package backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	
	public void init() {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fna = request.getParameter("restaurant");
		String lna = request.getParameter("location");
		if (fna.contentEquals("") || lna.contentEquals("")) {
			out.println("<h4>Name is missing!</h4>"); 
		} else {
			out.println("<h4>Submitted! Yay!</h4>"); 
		}
	}
	
	public void destroy() {
		
	}
}
