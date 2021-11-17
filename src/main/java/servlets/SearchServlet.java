package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles searching for restaurants using YelpAPI queries.
 * @author Thomas Peters
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3901610548642762613L;

	public void init() throws ServletException {
		
	}
	
	/**
	 * Request a search result from YelpAPI.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void destroy() {
		
	}

}
