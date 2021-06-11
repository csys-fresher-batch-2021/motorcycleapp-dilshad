package in.dilshad.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.dto.UnverifiedBikeDTO;
import in.dilshad.service.OwnerManager;

/**
 * Servlet implementation class GetUnverifiedBikeServlet
 */
@WebServlet("/GetUnverifiedBikeServlet")
public class GetUnverifiedBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUnverifiedBikeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UnverifiedBikeDTO> bikes = OwnerManager.getUnverifiedBikeList();
		request.setAttribute("TO_VERIFY_DETAILS", bikes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bikeStatusVerification.jsp");
		requestDispatcher.forward(request, response);
	}

	

}
