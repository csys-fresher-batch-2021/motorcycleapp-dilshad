package in.dilshad.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class DisplayBikesServlet
 */
@WebServlet("/DisplayBikesServlet")
public class DisplayBikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayBikesServlet() {
		super();
	}

	/**
	 * Gets List of bikes from the service layer and hand over to .jsp page for
	 * display.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BikeSpecification> bikeList = BikeManager.displayBikes();
		request.setAttribute("BIKE_LIST", bikeList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bikeList.jsp");
		requestDispatcher.forward(request, response);
	}

}
