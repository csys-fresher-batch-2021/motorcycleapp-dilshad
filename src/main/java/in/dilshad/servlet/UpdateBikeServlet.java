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
 * Servlet implementation class UpdateBikeServlet
 */
@WebServlet("/UpdateBikeServlet")
public class UpdateBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBikeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			String noPlate = (request.getParameter("noPlate").trim());
			Integer km = Integer.parseInt(request.getParameter("km"));
			Integer price = Integer.parseInt(request.getParameter("price"));
			BikeManager.updateBike(noPlate, km, price);
			out.print(true);
			out.flush();
		} catch (Exception e) {
			out.print(false);
			out.flush();
		}

	}

}
