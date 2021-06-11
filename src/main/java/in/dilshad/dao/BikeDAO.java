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
import in.dilshad.util.Constants;
import in.dilshad.util.Logger;

public class BikeDAO {

	private static final String PLATE_NO = "plate_no";
	private static final String VIN = "vin";
	private static final String FUEL_TYPE = "fuel_type";
	private static final String STATUS = "status";
	private static final String MANUFACTURE_YEAR = "manufacture_year";
	private static final String ODOMETER_READING = "odometer_reading";
	private static final String BIKE_PRICE = "bike_price";
	private static final String BIKE_COLOR = "bike_color";
	private static final String BIKE_MODEL = "bike_model";
	private static final String BIKE_MANUFACTURER = "bike_manufacturer";

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
			pst.setString(8, bikeSpecification.getEngineDetails().get(Constants.FUEL));
			pst.setString(9, bikeSpecification.getEngineDetails().get(Constants.VIN));
			pst.setString(10, bikeSpecification.getEngineDetails().get(Constants.PLATENO));
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.println(e.getMessage());
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
			String sql = "SELECT * FROM bike_specification WHERE status = 'true' ORDER BY bike_manufacturer";
			// Execution Step
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString(BIKE_MANUFACTURER));
				bikeSpecification.setBikeModel(result.getString(BIKE_MODEL));
				bikeSpecification.setBikeColor(result.getString(BIKE_COLOR));
				bikeSpecification.setBikePrice(result.getFloat(BIKE_PRICE));
				bikeSpecification.setKm(result.getInt(ODOMETER_READING));
				bikeSpecification.setManufactureYear(result.getInt(MANUFACTURE_YEAR));
				bikeSpecification.setStatus(result.getBoolean(STATUS));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put(Constants.FUEL, result.getString(FUEL_TYPE));
				engineDetails.put(Constants.VIN, result.getString(VIN));
				engineDetails.put(Constants.PLATENO, result.getString(PLATE_NO));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}
			System.out.println(bikeList);
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
		BikeSpecification bikeSpecification = null;
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
				bikeSpecification.setBikeManufacturer(result.getString(BIKE_MANUFACTURER));
				bikeSpecification.setBikeModel(result.getString(BIKE_MODEL));
				bikeSpecification.setBikeColor(result.getString(BIKE_COLOR));
				bikeSpecification.setBikePrice(result.getFloat(BIKE_PRICE));
				bikeSpecification.setKm(result.getInt(ODOMETER_READING));
				bikeSpecification.setManufactureYear(result.getInt(MANUFACTURE_YEAR));
				bikeSpecification.setStatus(result.getBoolean(STATUS));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put(Constants.FUEL, result.getString(FUEL_TYPE));
				engineDetails.put(Constants.VIN, result.getString(VIN));
				engineDetails.put(Constants.PLATENO, result.getString(PLATE_NO));
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

	/**
	 * This method update the odometer reading and price in the database.
	 * 
	 * @param noPlate
	 * @param km
	 * @param price
	 */
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
	 * Accepts Bike manufacture and Bike model as input and returns a list of bikes
	 * which partially resembles the input keyword.
	 * 
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
			String sql = "SELECT * FROM bike_specification WHERE bike_manufacturer ILIKE  ? AND bike_model ILIKE ?";

			System.out.println(sql);
			pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + manufacturer + "%");
			pst.setString(2, "%" + model + "%");

			result = pst.executeQuery();

			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString(BIKE_MANUFACTURER));
				bikeSpecification.setBikeModel(result.getString(BIKE_MODEL));
				bikeSpecification.setBikeColor(result.getString(BIKE_COLOR));
				bikeSpecification.setBikePrice(result.getFloat(BIKE_PRICE));
				bikeSpecification.setKm(result.getInt(ODOMETER_READING));
				bikeSpecification.setManufactureYear(result.getInt(MANUFACTURE_YEAR));
				bikeSpecification.setStatus(result.getBoolean(STATUS));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put(Constants.FUEL, result.getString(FUEL_TYPE));
				engineDetails.put(Constants.VIN, result.getString(VIN));
				engineDetails.put(Constants.PLATENO, result.getString(PLATE_NO));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		} catch (Exception e) {
			throw new DBException("Could not fetch bikes based on model");
		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return bikeList;
	}

	/**
	 * The method fetched list of bike which is between the given price limit in
	 * ascending order.
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
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

			result = pst.executeQuery();

			while (result.next()) {
				BikeSpecification bikeSpecification = new BikeSpecification();
				bikeSpecification.setBikeManufacturer(result.getString(BIKE_MANUFACTURER));
				bikeSpecification.setBikeModel(result.getString(BIKE_MODEL));
				bikeSpecification.setBikeColor(result.getString(BIKE_COLOR));
				bikeSpecification.setBikePrice(result.getFloat(BIKE_PRICE));
				bikeSpecification.setKm(result.getInt(ODOMETER_READING));
				bikeSpecification.setManufactureYear(result.getInt(MANUFACTURE_YEAR));
				bikeSpecification.setStatus(result.getBoolean(STATUS));
				Map<String, String> engineDetails = new HashMap<>();
				engineDetails.put(Constants.FUEL, result.getString(FUEL_TYPE));
				engineDetails.put(Constants.VIN, result.getString(VIN));
				engineDetails.put(Constants.PLATENO, result.getString(PLATE_NO));
				bikeSpecification.setEngineDetails(engineDetails);
				bikeList.add(bikeSpecification);
			}

		} catch (Exception e) {
			throw new DBException("Could not fetch bikes based on price range");
		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return bikeList;
	}

	/**
	 * Updates the status of bike from NOT_VERIFIED to VERIFIED for the given
	 * existing plate number.
	 * 
	 * @param plateNo
	 */
	public static void updateBikeStatustoTrue(String plateNo) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "UPDATE  bike_specification SET status = 'true' WHERE plate_no = ?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, plateNo);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DBException("Could not update the bike based on the plate number given");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}
}
