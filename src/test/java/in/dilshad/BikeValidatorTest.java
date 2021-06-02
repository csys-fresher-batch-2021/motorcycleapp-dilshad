package in.dilshad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.dilshad.validator.BikeValidator;

public class BikeValidatorTest {

	/**
	 * Test for Validating Bike Manufacture Name Should not contain number, special
	 * character
	 */
	@Test
	public void manufacturerTest() {
		String bikeManufacturer1 = "TVS";
		assertTrue(BikeValidator.isValidBikeManufacturer(bikeManufacturer1));

		String bikeManufacturer2 = "Royal Enfield";
		assertTrue(BikeValidator.isValidBikeManufacturer(bikeManufacturer2));

		String bikeManufacturer3 = "Hero Honda 500";
		assertFalse(BikeValidator.isValidBikeManufacturer(bikeManufacturer3));

		String bikeManufacturer4 = "Bajaj$";
		assertFalse(BikeValidator.isValidBikeManufacturer(bikeManufacturer4));
		
		String bikeManufacturer5 = "Royal Enfield ThunderBirdV";  //Greater than 20 characters
		assertFalse(BikeValidator.isValidBikeManufacturer(bikeManufacturer5));
	}

	/**
	 * Test for Validating Bike Model Name Should not contain special character
	 */
	@Test
	public void bikeModelTest() {
		String bikeModel1 = "Victor";
		assertTrue(BikeValidator.isValidBikeModel(bikeModel1));

		String bikeModel2 = "Apache 150";
		assertTrue(BikeValidator.isValidBikeModel(bikeModel2));

		String bikeModel3 = "Suzuki Access (125)";
		assertFalse(BikeValidator.isValidBikeModel(bikeModel3));

		String bikeModel4 = "TVS XL100*";
		assertFalse(BikeValidator.isValidBikeModel(bikeModel4));
		
		String bikeModel5 = "ThunderbikeV Royal Enfield";
		assertFalse(BikeValidator.isValidBikeModel(bikeModel5));
	}

	/**
	 * Test for Validating Bike Color Should not contain number, special character
	 */
	@Test
	public void bikeColorTest() {
		String bikeColor1 = "red";
		assertTrue(BikeValidator.isValidBikeColor(bikeColor1));

		String bikeColor2 = "Pale Green";
		assertTrue(BikeValidator.isValidBikeColor(bikeColor2));

		String bikeColor3 = "rgb(12,34,54)";
		assertFalse(BikeValidator.isValidBikeColor(bikeColor3));

		String bikeColor4 = "magenta & Purple";
		assertFalse(BikeValidator.isValidBikeColor(bikeColor4));
		
		String bikeColor5 = "bright magenta with purple linning";
		assertFalse(BikeValidator.isValidBikeColor(bikeColor5));
	}

	/**
	 * Test for Validating Bike Manufacture Price Should be 0 < Price < 300000
	 */
	@Test
	public void bikePriceTest() {
		float price1 = 20050;
		assertTrue(BikeValidator.isValidBikePrice(price1));

		float price2 = -45000;
		assertFalse(BikeValidator.isValidBikePrice(price2));

		float price3 = 900000;
		assertFalse(BikeValidator.isValidBikePrice(price3));

		float price4 = 0;
		assertTrue(BikeValidator.isValidBikePrice(price4));
	}

	/**
	 * Test for Validating Bike Odometer reading Should be 0 < Km < 500000
	 */
	@Test
	public void kmTest() {
		int reading1 = 4000;
		assertTrue(BikeValidator.isValidKm(reading1));

		int reading2 = 0;
		assertTrue(BikeValidator.isValidKm(reading2));

		int reading3 = -7000;
		assertFalse(BikeValidator.isValidKm(reading3));

		int reading4 = 1000000;
		assertFalse(BikeValidator.isValidKm(reading4));
	}

	/**
	 * Test for Validating Bike Year of Manufacture Should be 1900 < Year < Current
	 * year
	 */
	@Test
	public void yearTest() {
		int year1 = 2000;
		assertTrue(BikeValidator.isValidManufactureYear(year1));

		int year2 = 2025;
		assertFalse(BikeValidator.isValidManufactureYear(year2));

		int year3 = -2000;
		assertFalse(BikeValidator.isValidManufactureYear(year3));

		int year4 = 1790;
		assertFalse(BikeValidator.isValidManufactureYear(year4));

	}

	/**
	 * Test for Validating Bike Vehicle Identification Number Should be
	 * Alphanumeric, 17 characters, no special symbols
	 */
	@Test
	public void engineVIN() {
		String vin1 = "SDFR45YH78KRT654E";
		assertTrue(BikeValidator.isValidVin(vin1));

		String vin2 = "SDFR45yH78KRT654E";
		assertFalse(BikeValidator.isValidVin(vin2));

		String vin3 = "SDFR45YH78KRT654";
		assertFalse(BikeValidator.isValidVin(vin3));

		String vin4 = "$DFR45YH78KRT654E";
		assertFalse(BikeValidator.isValidVin(vin4));

		String vin5 = "SDFR45YH 78KRT654E";
		assertFalse(BikeValidator.isValidVin(vin5));

		String vin6 = "";
		assertFalse(BikeValidator.isValidVin(vin6));
	}

	/**
	 * Test for Validating Bike Plate Number Should be Alphanumeric, capital
	 * letters, no special characters Format: Alphabet(2) Number(2) Alphabet(1 to 3)
	 * Number(4) Sample: TN34V0967
	 */
	@Test
	public void plateNoTest() {
		String noPlate1 = "TN65DS2395";
		assertTrue(BikeValidator.isValidPlateNumber(noPlate1));

		String noPlate2 = "TN65FHY2034";
		assertTrue(BikeValidator.isValidPlateNumber(noPlate2));

		String noPlate3 = "TN65D6S2395";
		assertFalse(BikeValidator.isValidPlateNumber(noPlate3));

		String noPlate4 = "TN65D$2395";
		assertFalse(BikeValidator.isValidPlateNumber(noPlate4));

		String noPlate5 = "  ";
		assertFalse(BikeValidator.isValidPlateNumber(noPlate5));

		String noPlate6 = "TN65FHY204";
		assertFalse(BikeValidator.isValidPlateNumber(noPlate6));

	}

}
