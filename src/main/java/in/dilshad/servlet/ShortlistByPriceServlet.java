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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer min = Integer.parseInt(request.getParameter("minv"));
		Integer max = Integer.parseInt(request.getParameter("maxv"));
		System.out.println(("Servlet" + min));
		List<BikeSpecification> bikeList = BikeManager.shortlistByPrice(min, max);
		Gson gson = new Gson();
		String json = gson.toJson(bikeList);
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
	}
	
	}



}
