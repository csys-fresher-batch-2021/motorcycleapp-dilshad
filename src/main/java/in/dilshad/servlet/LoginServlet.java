package in.dilshad.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dilshad.validator.UserValidator;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");

		try {
			UserValidator.isValidCredentials(userName, password);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", userName);
			System.out.println(session.getAttribute("LOGGED_IN_USER"));
			response.sendRedirect("index.jsp?infoMessage=" + "Succesfully Logged in");
		} catch (IllegalArgumentException e) {
			response.sendRedirect("loginPage.jsp?errorMessage=" + e.getMessage());
		}

	}
}
