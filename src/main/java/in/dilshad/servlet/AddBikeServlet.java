package in.dilshad.servlet;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BikeSpecification newBike = new BikeSpecification();

		String infoMessage = "Successfull input";

		newBike.bikeManufacturer = request.getParameter("bikeManufacturer");
		newBike.bikeModel = request.getParameter("bikeModel");
		newBike.bikeColor = request.getParameter("bikeColor");
		newBike.engineDetails.put("fuelType", request.getParameter("fuelType"));
		newBike.engineDetails.put("vin", request.getParameter("vin"));
		newBike.engineDetails.put("noPlate", request.getParameter("noPlate"));
		newBike.status = Boolean.parseBoolean(request.getParameter("status"));

		try {
			newBike.km = Integer.parseInt(request.getParameter("km"));
			newBike.manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));
			newBike.bikePrice = Float.parseFloat(request.getParameter("price"));
			try {
				BikeManager.addBike(newBike);
				response.sendRedirect("BikeList.jsp?infoMessage=" + infoMessage);

			} catch (Exception e) {
				response.sendRedirect("Addbike.jsp?errorMessage=" + e.getMessage());
			}
		} catch (Exception e) {
			response.sendRedirect("Addbike.jsp?errorMessage=" + e.getMessage());
		}

	}

}
