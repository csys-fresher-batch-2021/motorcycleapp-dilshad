package in.dilshad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.service.BikeManager;
import in.dilshad.service.OwnerManager;

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
			OwnerManager.removeOwnerDetails(noPlate);
			out.print(true);
			out.flush();
		} catch (Exception e) {
			out.print(false);
			out.flush();
		}

	}

}
