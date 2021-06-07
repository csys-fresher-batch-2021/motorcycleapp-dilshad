package in.dilshad.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dilshad.model.AdminDetails;
import in.dilshad.service.AdminManager;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Accepts Login credentials and handover to Service layer.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setID(request.getParameter("uname"));
		adminDetails.setPassword(request.getParameter("pass"));

		try {
			String name = AdminManager.adminLogin(adminDetails);
			if (name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_ADMIN", name);
				response.sendRedirect("index.jsp?infoMessage= Succesfully Logged in");
			} else {
				response.sendRedirect("loginPage.jsp?errorMessage=Invalid Credentials");
			}
		} catch (Exception e) {
			response.sendRedirect("loginPage.jsp?errorMessage=" + e.getMessage());
		}

	}
}
