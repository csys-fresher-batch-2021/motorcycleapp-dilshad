package in.dilshad.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class SearchByPlateNoServlet
 */
@WebServlet("/SearchByPlateNoServlet")
public class SearchByPlateNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchByPlateNoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Get Form Values
		String plateNo = (request.getParameter("noPlate").trim());

		Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
		BikeSpecification bikeSpecification = bikeList.get(plateNo);
		request.setAttribute("BIKE_SPECIFICATION", bikeSpecification);

		RequestDispatcher dispatcher = request.getRequestDispatcher("displayByPlateNo.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// Sonar cloud tells to put try catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Sonar cloud tells to put try catch block
			e.printStackTrace();
		}
	}
}
