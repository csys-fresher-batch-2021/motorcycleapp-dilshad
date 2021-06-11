package in.dilshad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class RemoveUnverifiedBikeServlet
 */
@WebServlet("/RemoveUnverifiedBikeServlet")
public class RemoveUnverifiedBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveUnverifiedBikeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String noPlate = request.getParameter("noPlate").trim();
			BikeManager.removeBike(noPlate);
			response.sendRedirect(
					"GetUnverifiedBikeServlet?infoMessage= Bike no." + noPlate + " Successfully removed from database.");
		} catch (Exception e) {
			response.sendRedirect("GetUnverifiedBikeServlet?errorMessage=" + e.getMessage());
		}
	}

}
