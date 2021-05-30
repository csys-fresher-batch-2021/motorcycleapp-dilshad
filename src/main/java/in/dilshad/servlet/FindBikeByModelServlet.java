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

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;
import in.dilshad.util.Logger;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		List<BikeSpecification> bikeList = BikeManager.findBikeByModel(manufacturer, model);
		Gson gson = new Gson();
		String json = gson.toJson(bikeList);
		Logger.println("GSON JAR \n" + json);
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
	}

}
}