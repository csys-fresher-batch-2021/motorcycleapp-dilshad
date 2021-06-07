package in.dilshad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class FindBikeByModelServlet
 */
@WebServlet("/FindBikeByModelServlet")
public class FindBikeByModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindBikeByModelServlet() {
		super();
	}

	/**
	 * Accepts either or both fields and handover to service Layer.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");

		PrintWriter out = response.getWriter();

		try {
			List<BikeSpecification> bikeList = BikeManager.findBikeByModel(manufacturer, model);
			Gson gson = new Gson();
			if (bikeList.isEmpty()) {
				JsonObject object = new JsonObject();
				object.addProperty("errorMessage", "Try with other keywords");
				out.print(object.toString());
			} else {
				String json = gson.toJson(bikeList);
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