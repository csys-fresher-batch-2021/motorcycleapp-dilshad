package in.dilshad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class RemoveBikeServlet
 */
@WebServlet("/RemoveBikeServlet")
public class RemoveBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveBikeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noPlate = request.getParameter("noPlate").trim();
		PrintWriter out = response.getWriter();

		try {
			BikeManager.removeBike(noPlate);

			// PrintWriter out = response.getWriter();
			out.print(true);
			out.flush();
			// response.sendRedirect("DisplayBikesServlet?infoMessage=" + "Removed bike
			// record successfully");
		} catch (Exception e) {
			out.print(false);
			out.flush();
			// response.sendRedirect("DisplayBikesServlet?errorMessage=" + e.getMessage());
		}

	}

}
