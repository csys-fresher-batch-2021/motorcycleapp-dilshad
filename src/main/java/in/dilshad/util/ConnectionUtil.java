package in.dilshad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.dilshad.exception.DBException;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default Constructor
	}

	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	/**
	 * This Method Will get the Connection from the Database
	 * 
	 * @return
	 * @throws DBException
	 */
	public static Connection getConnection() throws DBException {
		// Step 2: Get the connection
		Connection connection = null;
		try {
			// Load the JDBC driver in memory
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Connection From Data Base");
		}
		return connection;
	}

	/**
	 * This method closes the connection from database
	 * 
	 * @param pst
	 * @param connection
	 */
	public static void closeConnection(Statement pst, Connection connection) {
		try {
			if (pst != null) {
				pst.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to CLose the connection");
		}
	}

	/**
	 * This method closes the connection from database
	 * 
	 * @param rs
	 * @param pst
	 * @param connection
	 */
	public static void closeConnection(ResultSet rs, Statement pst, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to CLose the connection");
		}
	}
}