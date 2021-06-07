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
 * Servlet implementation class ShortlistByPriceServlet
 */
@WebServlet("/ShortlistByPriceServlet")
public class ShortlistByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShortlistByPriceServlet() {
		super();
	}

	/**
	 * Accepts values and handover to service layer.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			Integer min = Integer.parseInt(request.getParameter("minv"));
			Integer max = Integer.parseInt(request.getParameter("maxv"));

			Gson gson = new Gson();
			List<BikeSpecification> bikeList = BikeManager.shortlistByPrice(min, max);
			if (bikeList.isEmpty()) {
				JsonObject object = new JsonObject();
				object.addProperty("errorMessage", "No bikes found for given price limits");
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
