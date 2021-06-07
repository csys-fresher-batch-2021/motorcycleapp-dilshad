package in.dilshad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class SearchByPlateNoJsonServlet
 */
@WebServlet("/GetByPlateNoServlet")
public class GetByPlateNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetByPlateNoServlet() {
		super();
	}

	/**
	 * Accepts Plate number and handover to Service layer.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String plateNo = request.getParameter("noPlate");
		PrintWriter out = response.getWriter();

		try {
			Gson gson = new Gson();
			BikeSpecification bikeSpecification = BikeManager.searchByPlateNo(plateNo);

			if (bikeSpecification == null) {

				JsonObject object = new JsonObject();
				object.addProperty("errorMessage", "Plate number not found");
				out.print(object.toString());
			} else {
				String json = gson.toJson(bikeSpecification);
				out.print(json);
			}
		} catch (Exception e) {
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.print(object.toString());
		}
		out.flush();
	}
}
