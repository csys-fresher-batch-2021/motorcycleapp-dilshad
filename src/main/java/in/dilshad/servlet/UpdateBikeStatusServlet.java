package in.dilshad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.service.BikeManager;

/**
 * Servlet implementation class UpdateBikeStatusServlet
 */
@WebServlet("/UpdateBikeStatusServlet")
public class UpdateBikeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBikeStatusServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String plateNo = request.getParameter("plateNo");
		BikeManager.updateBikeStatus(plateNo);
		String infoMessage = "Successfully updated";
		response.sendRedirect("GetUnverifiedBikeServlet?infoMessage=" + infoMessage);
		}catch (Exception e) {
			response.sendRedirect("GetUnverifiedBikeServlet?errorMessage=" + e.getMessage());
		}
		
	}



}
