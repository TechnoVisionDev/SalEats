package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Handles interacts with the MySQL database.
 * @author Thomas Peters
 */
public class Database {
	
	private static String MYSQL_KEY = "jdbc:mysql://localhost:3306/auth";
	private static String USERNAME = "root";
	private static String PASSWORD = "password";

	/**
	 * Adds a user object to the MySQL database.
	 * @return Statement result integer.
	 */
	public int registerUser(User user) throws SQLIntegrityConstraintViolationException {
		String INSERT_USERS_SQL = "INSERT INTO users (email, name, password) VALUES (?, ?, ?)";
		int result = 0;
		try {
			// Connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(MYSQL_KEY, USERNAME, PASSWORD);
			
			// Insert new user to database
			PreparedStatement statement = conn.prepareStatement(INSERT_USERS_SQL);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			result = statement.executeUpdate();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new SQLIntegrityConstraintViolationException();
			}
		}
		return result;
	}
	
	/**
	 * Validates a email and password pair for login.
	 * @return true if validated.
	 */
	public boolean validate(String email, String password) {
		String SELECT_USERS_SQL = "SELECT * FROM users WHERE email = ? AND password = ?";
		boolean status = false;
		try {
			// Connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(MYSQL_KEY, USERNAME, PASSWORD);
			
			// Check if email and password match 
			PreparedStatement statement = conn.prepareStatement(SELECT_USERS_SQL);
			statement.setString(1, email);
			statement.setString(2, password);
	
			ResultSet rs = statement.executeQuery();
			status = rs.next();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {}
		return status;
	}
	
	/**
	 * Access the name associated with a specified email
	 * @return queried name or "Username" if null
	 */
	public String getName(String email) {
		String SELECT_NAME_SQL = "SELECT name FROM users WHERE email = " + email;
		try {
			// Connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(MYSQL_KEY, USERNAME, PASSWORD);
			
			// Grab queried name
			PreparedStatement statement = conn.prepareStatement(SELECT_NAME_SQL);
			ResultSet rs = statement.executeQuery();
			return rs.getString("name");
		} catch (SQLException | ClassNotFoundException e) {}
		return "Username";
	}
}
