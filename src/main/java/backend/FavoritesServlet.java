package backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles adding and removing restaurants to the favorites list.
 * @author Thomas Peters
 */
@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {
	
	public void init() throws ServletException {
		
	}
	
	/**
	 * Adds a new restaurant to the favorites list
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	/**
	 * Removes a restaurant from the favorites list
	 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void destroy() {
		
	}

}
