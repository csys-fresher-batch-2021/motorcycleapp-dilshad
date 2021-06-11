package in.dilshad.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.dto.OwnerDTO;
import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;
import in.dilshad.service.OwnerManager;

/**
 * Servlet implementation class Addbike
 */
@WebServlet("/Addbikeservlet")
public class AddBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Accepts Bike specification inputs and hands over to Service layer.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BikeSpecification newBike = new BikeSpecification();
		OwnerDTO ownerDTO = new OwnerDTO();

		String infoMessage = "Successfull input";

		newBike.setBikeManufacturer(request.getParameter("bikeManufacturer").trim());
		newBike.setBikeModel(request.getParameter("bikeModel").trim());
		newBike.setBikeColor(request.getParameter("bikeColor").trim());
		Map<String, String> engineDetails = new HashMap<>();
		engineDetails.put("fuelType", request.getParameter("fuelType").trim());
		engineDetails.put("vin", request.getParameter("vin").trim());
		engineDetails.put("noPlate", request.getParameter("noPlate").trim());
		newBike.setEngineDetails(engineDetails);

		ownerDTO.setOwnerName(request.getParameter("ownerName").trim());
		ownerDTO.setOwnerAddress(request.getParameter("ownerAddress").trim());
		ownerDTO.setBikePlateNo(request.getParameter("noPlate").trim());
		
		try {
			ownerDTO.setOwnerPhoneNo(Long.parseLong(request.getParameter("ownerPhoneNo")));

			newBike.setKm(Integer.parseInt(request.getParameter("km").trim()));
			newBike.setManufactureYear(Integer.parseInt(request.getParameter("manufactureYear").trim()));
			newBike.setBikePrice(Float.parseFloat(request.getParameter("price").trim()));
			BikeManager.addBike(newBike);
			
			OwnerManager.addOwnerDetails(ownerDTO);
			response.sendRedirect("DisplayBikesServlet?infoMessage=" + infoMessage);

		} catch (Exception e) {
			response.sendRedirect("addBike.jsp?errorMessage=" + e.getMessage());
		}

	}

}
