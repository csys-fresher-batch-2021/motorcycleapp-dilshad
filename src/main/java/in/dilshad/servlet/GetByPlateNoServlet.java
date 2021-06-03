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
import in.dilshad.util.Logger;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get Form Values
		String plateNo = request.getParameter("noPlate");
		PrintWriter out = response.getWriter();
		try {
			BikeSpecification bikeSpecification = BikeManager.searchByPlateNo(plateNo);
			// Step 2: Convert to Json string
			Gson gson = new Gson();

			if (bikeSpecification == null) {
				// out.print(json);
				JsonObject object = new JsonObject();
				object.addProperty("errorMessage", "PlateNo not found");
				out.print(object.toString());
			} else {
				String json = gson.toJson(bikeSpecification);
				Logger.println("Approach #2: GSON JAR \n" + json);
				out.print(json);
			}
		} catch (Exception e) {

			e.printStackTrace();
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.print(object.toString());
		}

		out.flush();
	}

}
