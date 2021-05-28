package in.dilshad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.dilshad.exception.DBException;
import in.dilshad.model.BikeSpecification;
import in.dilshad.util.ConnectionUtil;

public class BikeDAO {

	private BikeDAO() {
		// Default constructor
	}

	/**
	 * To add new bike into the database Table
	 * 
	 * @param bikeSpecification
	 * @throws DBException
	 */
	public static void addBike(BikeSpecification bikeSpecification) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "insert into Bike_Specification(Bike_Manufacturer, Bike_Model, Bike_color,  Bike_Price, Odometer_Reading, Manufacture_Year, Status, Fuel_Type, VIN, Plate_No ) values (?,?,?,?,?,?,?,?,?,?)";

			// Execution Step
			pst = connection.prepareStatement(sql);

			pst.setString(1, bikeSpecification.getBikeManufacturer());
			pst.setString(2, bikeSpecification.getBikeModel());
			pst.setString(3, bikeSpecification.getBikeColor());
			pst.setFloat(4, bikeSpecification.getBikePrice());
			pst.setInt(5, bikeSpecification.getKm());
			pst.setInt(6, bikeSpecification.getManufactureYear());
			pst.setBoolean(7, bikeSpecification.isStatus());
			pst.setString(8, bikeSpecification.getEngineDetails().get("fuelType"));
			pst.setString(9, bikeSpecification.getEngineDetails().get("vin"));
			pst.setString(10, bikeSpecification.getEngineDetails().get("noPlate"));
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add Details");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	/**
	 * To get All bikes from Database table
	 * 
	 * @return
	 */
	public static List<BikeSpecification> getAllBikes() {
		final List<BikeSpecification> bikeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "SELECT * FROM Bike_Specification";
			// Execution Step
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString("Bike_Manufacturer"));
				bikeSpecification.setBikeModel(result.getString("Bike_Model"));
				bikeSpecification.setBikeColor(result.getString("Bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("Bike_Price"));
				bikeSpecification.setKm(result.getInt("Odometer_Reading"));
				bikeSpecification.setManufactureYear(result.getInt("Manufacture_Year"));
				bikeSpecification.setStatus(result.getBoolean("Status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("Fuel_Type"));
				engineDetails.put("vin", result.getString("VIN"));
				engineDetails.put("noPlate", result.getString("Plate_No"));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch details from database table");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return bikeList;
	}

	/**
	 * To fetch bike details using Plate Number - Primary Key
	 * 
	 * @param plateNo
	 * @return
	 */
	public static BikeSpecification getByPlateNo(String plateNo) {
		BikeSpecification bikeSpecification = new BikeSpecification();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM Bike_Specification WHERE Plate_No =?";
			pst = connection.prepareStatement(sql);

			pst.setString(1, plateNo);

			result = pst.executeQuery();
			while (result.next()) {
				bikeSpecification.setBikeManufacturer(result.getString("Bike_Manufacturer"));
				bikeSpecification.setBikeModel(result.getString("Bike_Model"));
				bikeSpecification.setBikeColor(result.getString("Bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("Bike_Price"));
				bikeSpecification.setKm(result.getInt("Odometer_Reading"));
				bikeSpecification.setManufactureYear(result.getInt("Manufacture_Year"));
				bikeSpecification.setStatus(result.getBoolean("Status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("Fuel_Type"));
				engineDetails.put("vin", result.getString("VIN"));
				engineDetails.put("noPlate", result.getString("Plate_No"));
				bikeSpecification.setEngineDetails(engineDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch bike for Plate no." + plateNo);
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return bikeSpecification;
	}
}
