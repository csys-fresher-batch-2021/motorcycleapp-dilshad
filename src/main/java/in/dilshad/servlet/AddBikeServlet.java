package in.dilshad.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class Addbike
 */
@WebServlet("/Addbikeservlet")
public class AddBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BikeSpecification newBike = new BikeSpecification();

		String infoMessage = "Successfull input";

		newBike.setBikeManufacturer(request.getParameter("bikeManufacturer"));
		newBike.setBikeModel(request.getParameter("bikeModel"));
		newBike.setBikeColor(request.getParameter("bikeColor"));
		Map<String, String> engineDetails = new HashMap<>();
		engineDetails.put("fuelType", request.getParameter("fuelType"));
		engineDetails.put("vin", request.getParameter("vin"));
		engineDetails.put("noPlate", request.getParameter("noPlate"));
		newBike.setEngineDetails(engineDetails);
		newBike.setStatus(Boolean.parseBoolean(request.getParameter("status")));

		try {
			newBike.setKm(Integer.parseInt(request.getParameter("km")));
			newBike.setManufactureYear(Integer.parseInt(request.getParameter("manufactureYear")));
			newBike.setBikePrice(Float.parseFloat(request.getParameter("price")));
			BikeManager.addBike(newBike);
			response.sendRedirect("BikeList.jsp?infoMessage=" + infoMessage);

		} catch (Exception e) {
			response.sendRedirect("Addbike.jsp?errorMessage=" + e.getMessage());
		}

	}

}
