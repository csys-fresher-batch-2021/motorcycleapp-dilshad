package in.dilshad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class SearchByPlateNoJsonServlet
 */
@WebServlet("/SearchByPlateNoJsonServlet")
public class SearchByPlateNoJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchByPlateNoJsonServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get Form Values
		String plateNo = (request.getParameter("noPlate"));

		BikeSpecification bikeSpecification = new BikeSpecification();
		Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
		// Step 2: Convert to Json string

		bikeSpecification = bikeList.get(plateNo);

		Gson gson = new Gson();
		String json = gson.toJson(bikeSpecification);
		System.out.println("Approach #2: GSON JAR \n" + json);

		// Step 3: Write the json in response and flush it
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
