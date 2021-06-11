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

import in.dilshad.dto.OwnerDTO;
import in.dilshad.service.OwnerManager;

/**
 * Servlet implementation class GetOwnerDetailsServlet
 */
@WebServlet("/GetOwnerDetailsServlet")
public class GetOwnerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOwnerDetailsServlet() {
		super();
	}

	/**
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
			OwnerDTO owner = OwnerManager.getOwnerDetails(plateNo);

			if (owner == null) {

				JsonObject object = new JsonObject();
				object.addProperty("errorMessage", "Owner details not found");
				out.print(object.toString());
			} else {
				String json = gson.toJson(owner);
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
