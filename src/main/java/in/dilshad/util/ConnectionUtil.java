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

	/**
	 * This Method Will get the Connection from the Data BAse
	 * 
	 * @return
	 * @throws DBException
	 */
	public static Connection getConnection() throws DBException {
		// Step 2: Get the connection
		Connection connection = null;
		try {
			 String driverClass = "org.postgresql.Driver";
			 String url = "jdbc:postgresql://projecttracker.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com/motorcycleapp";
			 String username = "prod_user";
			 String password = "prod_user";

			// Load the JDBC driver in memory
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Connection From Data Base");
		}
		return connection;
	}

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