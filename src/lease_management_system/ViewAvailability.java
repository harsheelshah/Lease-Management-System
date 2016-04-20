package lease_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hw2/ViewAvailability")
public class ViewAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String apptno = request.getParameter("aptno");

		String username = request.getParameter("username");

		ServletContext context = this.getServletContext();

		ArrayList<Application> appList = (ArrayList<Application>) context
				.getAttribute("ApplicationList");
		List<UserDetails> userdetails = (List<UserDetails>) getServletContext()
				.getAttribute("userdetails");

		if (appList == null) {
			System.out.println("test");
		}

		// System.out.println(appList.size());

		request.setAttribute("Application", appList);
		request.setAttribute("userdetails", userdetails);

		request.getRequestDispatcher("ViewAvailability.jsp").forward(request,
				response);

		// response.sendRedirect("ViewAvailability.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = this.getServletContext();
		String schedule_date = request.getParameter("apdate");

		String username = request.getParameter("username");
		String aptno = request.getParameter("aptno");
		// System.out.println(username);

		ArrayList<Application> appList = (ArrayList<Application>) context
				.getAttribute("ApplicationList");

		for (Application a : appList) {
			if (a.getApartmentNo().equals(aptno)
					&& a.getUsername().equals(username)) {
				a.setRescheduledDate(schedule_date);
			}
		}

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// final String DB_URL = "jdbc:mysql://localhost/cs320stu141";
		final String DB_URL = "jdbc:mysql://cs3.calstatela.edu/cs320stu141";

		final String USER = "cs320stu141";
		// final String PASS = "abcd";
		final String PASS = "8Xn#BV5x";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		try {

			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			statement = connection.createStatement();

			String query = "";
			String query1 = "";

			query = "update cs320stu141.apartmentdetails set AppointmentDate = '"
					+ schedule_date + "' where ApartmentNo = '" + aptno + "'";
			query1 = "update cs320stu141.application set RescheduledDate = '"
					+ schedule_date + "' where Username = '" + username
					+ "' and ApartmentNo = '" + aptno + "'";
			PreparedStatement statement1 = connection.prepareStatement(query);
			PreparedStatement statement2 = connection.prepareStatement(query1);
			statement1.executeUpdate();
			statement2.executeUpdate();

			resultSet = statement1.executeQuery(query);
			resultSet = statement2.executeQuery(query1);

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			System.out.println(e);

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		ArrayList<ApartmentDetails> appdet = (ArrayList<ApartmentDetails>) context
				.getAttribute("ApartmentDetails");

		for (int i = 0; i < appdet.size(); i++) {
			if (appdet.get(i).ApartmentNo.equals(aptno)) {
				appdet.get(i).setAppointmentDate(schedule_date);
				// appdet.get(i).setUserName(username);
			}
		}

		// System.out.println(schedule_date);

		request.getRequestDispatcher("ViewApartment.jsp").forward(request,
				response);

	}
}