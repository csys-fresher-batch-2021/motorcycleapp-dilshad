package in.dilshad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.dilshad.exception.DBException;
import in.dilshad.model.AdminDetails;
import in.dilshad.util.ConnectionUtil;

public class AdminDAO {
	private AdminDAO() {

	}

	/**
	 * This method includes the new Admin details in the database
	 * 
	 * @param adminDetails
	 */
	public static void addDAO(AdminDetails adminDetails) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			System.out.println("Connection established");
			// Sql command
			String sql = "insert into admin_details(admin_name, admin_id, admin_password) values (?,?,?)";

			// Execution Step
			pst = connection.prepareStatement(sql);
			System.out.println(adminDetails.getID());

			pst.setString(1, adminDetails.getName());
			pst.setString(2, adminDetails.getID());
			pst.setString(3, adminDetails.getPassword());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to Add Details");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	/**
	 * It accepts admin details and validates, if exist in database returns admin
	 * name else returns null.
	 * 
	 * @param adminDetails
	 * @return
	 */
	public static String loginVerificationDAO(AdminDetails adminDetails) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		String name = null;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			System.out.println("Connection established");
			// Sql command
			String sql = "SELECT * FROM  admin_details  WHERE  admin_id = ? AND admin_password = ?";

			// Execution Step
			pst = connection.prepareStatement(sql);
			pst.setString(1, adminDetails.getID());
			pst.setString(2, adminDetails.getPassword());

			result = pst.executeQuery();

			if (result.next()) {
				name = result.getString("admin_name");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Already exist");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return name;
	}

}
