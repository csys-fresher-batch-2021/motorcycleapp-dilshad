package in.dilshad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.dilshad.dto.OwnerDTO;
import in.dilshad.dto.UnverifiedBikeDTO;
import in.dilshad.exception.DBException;
import in.dilshad.util.ConnectionUtil;
import in.dilshad.util.Logger;

public class OwnerDAO {
	/**
	 * Adds owner details to the database
	 * 
	 * @param owner
	 */
	public static void addOwner(OwnerDTO owner) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "insert into seller_details(seller_bike_no, seller_name, seller_address,  seller_mobile_no ) values (?,?,?,?)";

			// Execution Step
			pst = connection.prepareStatement(sql);

			pst.setString(1, owner.getBikePlateNo());
			pst.setString(2, owner.getOwnerName());
			pst.setString(3, owner.getOwnerAddress());
			pst.setLong(4, owner.getOwnerPhoneNo());

			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.println(e);
			throw new DBException("Unable to Add Details");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	/**
	 * Gives the list of partial bike specification and owner details of the
	 * unverified bikes.
	 * 
	 * @return
	 */
	public static List<UnverifiedBikeDTO> getUnverifiedBikes() {
		final List<UnverifiedBikeDTO> bikeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command

			String sql = "\r\n"
					+ "SELECT bike_specification.plate_no, bike_specification.bike_model, seller_details.seller_name, seller_details.seller_address, seller_details.seller_mobile_no, seller_details.created_date\r\n"
					+ "FROM (bike_specification INNER JOIN seller_details ON bike_specification.plate_no = seller_details.seller_bike_no)\r\n"
					+ "WHERE bike_specification.status = 'false'\r\n" + "ORDER BY seller_details.created_date ASC";

			// Execution Step
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				UnverifiedBikeDTO unverifiedBikeList = new UnverifiedBikeDTO();
				unverifiedBikeList.setPlateNo(result.getString("plate_no"));
				unverifiedBikeList.setBikeModel(result.getString("bike_model"));
				unverifiedBikeList.setOwnerName(result.getString("seller_name"));
				unverifiedBikeList.setOwnerAddress(result.getString("seller_address"));
				unverifiedBikeList.setOwnerPhoneNo(result.getLong("seller_mobile_no"));
				Timestamp timestamp = result.getTimestamp("created_date");
				LocalDateTime createdDate = timestamp.toLocalDateTime(); // Auditing table
				unverifiedBikeList.setAddedTime(createdDate);
					bikeList.add(unverifiedBikeList);
			}
		} catch (SQLException e) {
			Logger.println(e);
			throw new DBException("Unable to Fetch details from database table");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return bikeList;
	}

	/**
	 * Removes the Owner details by providing bike plate number
	 * 
	 * @param noPlate
	 */
	public static void removeOwner(String noPlate) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "DELETE FROM seller_details WHERE seller_bike_no = ?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, noPlate);
			int status = pst.executeUpdate();
			if (status == 0)
				throw new DBException("No bikes found for the plate no:" + noPlate);
		} catch (Exception e) {
			Logger.println(e);
			throw new DBException("Could not remove the bike based on the plate number given");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	/**
	 * Get owner details for the given plate number.
	 * 
	 * @param plateNo
	 * @return
	 */
	public static OwnerDTO getOwnerDetails(String plateNo) {
		OwnerDTO owner = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT seller_name, seller_address, seller_mobile_no  FROM seller_details WHERE seller_bike_no =?;";
			pst = connection.prepareStatement(sql);

			pst.setString(1, plateNo);

			result = pst.executeQuery();
			if (result.next()) {
				owner = new OwnerDTO();
				owner.setOwnerName(result.getString("seller_name"));
				owner.setOwnerAddress(result.getString("seller_address"));
				owner.setOwnerPhoneNo(result.getLong("seller_mobile_no"));
			}
		} catch (Exception e) {
			Logger.println(e);
			throw new DBException("Unable to Fetch Owner details");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return owner;
	}
}