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
			String sql = "insert into bike_specification(bike_manufacturer, bike_model, bike_color,  bike_price, odometer_reading, manufacture_year, status, fuel_type, vin, plate_no ) values (?,?,?,?,?,?,?,?,?,?)";

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
			String sql = "SELECT * FROM bike_specification";
			// Execution Step
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString("bike_manufacturer"));
				bikeSpecification.setBikeModel(result.getString("bike_model"));
				bikeSpecification.setBikeColor(result.getString("bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("bike_price"));
				bikeSpecification.setKm(result.getInt("odometer_reading"));
				bikeSpecification.setManufactureYear(result.getInt("manufacture_year"));
				bikeSpecification.setStatus(result.getBoolean("status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("fuel_type"));
				engineDetails.put("vin", result.getString("vin"));
				engineDetails.put("noPlate", result.getString("plate_no"));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		} catch (SQLException e) {
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
		BikeSpecification bikeSpecification =null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM Bike_Specification WHERE Plate_No =?";
			pst = connection.prepareStatement(sql);

			pst.setString(1, plateNo);

			result = pst.executeQuery();
			if (result.next()) {
				bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString("bike_manufacturer"));
				bikeSpecification.setBikeModel(result.getString("bike_model"));
				bikeSpecification.setBikeColor(result.getString("bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("bike_price"));
				bikeSpecification.setKm(result.getInt("odometer_reading"));
				bikeSpecification.setManufactureYear(result.getInt("manufacture_year"));
				bikeSpecification.setStatus(result.getBoolean("status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("fuel_type"));
				engineDetails.put("vin", result.getString("vin"));
				engineDetails.put("noPlate", result.getString("plate_no"));
				bikeSpecification.setEngineDetails(engineDetails);
			}
		} catch (Exception e) {
			throw new DBException("Unable to Fetch bike for Plate no." + plateNo);
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return bikeSpecification;
	}

	/**
	 * Plate number is passes as argument. Removes corresponding bike record from
	 * database.
	 * 
	 * @param noPlate
	 */
	public static void removeBike(String noPlate) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "DELETE FROM bike_specification WHERE plate_no = ?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, noPlate);
			int status = pst.executeUpdate();
			if (status == 0)
				throw new DBException("No bikes found for the plate no:" + noPlate);
		} catch (Exception e) {
			throw new DBException("Could not remove the bike based on the plate number given");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	public static void updateBike(String noPlate, int km, int price) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "UPDATE  bike_specification SET odometer_reading = ?, bike_price = ? WHERE plate_no = ?";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, km);
			pst.setInt(2, price);
			pst.setString(3, noPlate);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DBException("Could not update the bike based on the plate number given");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	/**
	 * Accepts Bike manufacture and Bike model as input and returns a list of bikes which
	 * partially resembles the input keyword.
	 * @param manufacturer
	 * @param model
	 * @return
	 */
	public static List<BikeSpecification> findBikeByModel(String manufacturer, String model) {
		final List<BikeSpecification> bikeList = new ArrayList<>();


		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM bike_specification WHERE bike_manufacturer ILIKE  ? OR bike_model ILIKE ?;";
			pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + manufacturer + "%");
			pst.setString(2, "%" + model + "%");
			
			result=pst.executeQuery();
			
			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString("bike_manufacturer"));
				bikeSpecification.setBikeModel(result.getString("bike_model"));
				bikeSpecification.setBikeColor(result.getString("bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("bike_price"));
				bikeSpecification.setKm(result.getInt("odometer_reading"));
				bikeSpecification.setManufactureYear(result.getInt("manufacture_year"));
				bikeSpecification.setStatus(result.getBoolean("status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("fuel_type"));
				engineDetails.put("vin", result.getString("vin"));
				engineDetails.put("noPlate", result.getString("plate_no"));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		}catch (Exception e) {

				throw new DBException("Could not fetch bikes based on model");
		}
		finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return bikeList;
	}
	
	public static List<BikeSpecification> shortlistByPrice(int min, int max) {
		final List<BikeSpecification> bikeList = new ArrayList<>();


		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM bike_specification WHERE bike_price BETWEEN ? AND ? ORDER BY bike_price ASC ";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, min);
			pst.setInt(2, max);
			
			result=pst.executeQuery();
			
			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString("bike_manufacturer"));
				bikeSpecification.setBikeModel(result.getString("bike_model"));
				bikeSpecification.setBikeColor(result.getString("bike_color"));
				bikeSpecification.setBikePrice(result.getFloat("bike_price"));
				bikeSpecification.setKm(result.getInt("odometer_reading"));
				bikeSpecification.setManufactureYear(result.getInt("manufacture_year"));
				bikeSpecification.setStatus(result.getBoolean("status"));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put("fuelType", result.getString("fuel_type"));
				engineDetails.put("vin", result.getString("vin"));
				engineDetails.put("noPlate", result.getString("plate_no"));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		}catch (Exception e) {

				throw new DBException("Could not fetch bikes based on price range");
		}
		finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return bikeList;
	}
}
