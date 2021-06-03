package in.dilshad.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dilshad.model.AdminDetails;
import in.dilshad.service.AdminManager;

/**
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdminDetails adminDetails = new AdminDetails();
			adminDetails.setName(request.getParameter("name"));
			adminDetails.setID(request.getParameter("id"));
			adminDetails.setPassword(request.getParameter("pass"));
			AdminManager.registerAdmin(adminDetails);
			response.sendRedirect("loginPage.jsp?infoMessage=" + "Successful");
		} catch (Exception e) {
			response.sendRedirect("adminRegister.jsp?errorMessage=" + e.getMessage());
		}

	}
}
