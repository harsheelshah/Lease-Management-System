package lease_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

//import java.sql.PreparedStatement;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentOut
 */
@WebServlet("/hw2/RentOut")
public class RentOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = this.getServletContext();

		String aptno = request.getParameter("aptno");

		String username = request.getParameter("username");

		ArrayList<ApartmentDetails> appdet = (ArrayList<ApartmentDetails>) context
				.getAttribute("ApartmentDetails");
		request.setAttribute("appdet", appdet);

		ArrayList<Application> Application = (ArrayList<lease_management_system.Application>) context
				.getAttribute("ApplicationList");
		request.setAttribute("application", Application);

		request.setAttribute("aptno", aptno);
		request.setAttribute("username", username);

		request.getRequestDispatcher("RentOut.jsp").forward(request, response);
		// response.sendRedirect("RentOut.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = this.getServletContext();
		// String schedule_date = request.getParameter("apdate");
		String apptno = request.getParameter("aptno");

		String username = request.getParameter("username");

		/*
		 * System.out.println(apptno); System.out.println(username);
		 */

		if (request.getParameter("rentout") != null) {
			ArrayList<Application> appList = (ArrayList<Application>) context
					.getAttribute("ApplicationList");

			for (Application a : appList) {
				if (a.getApartmentNo().equals(apptno)
						&& a.getUsername().equals(username)) {
					a.setStatus("Rented");
					// System.out.println("applist status changed");

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

				query = "update cs320stu141.apartmentdetails set AppointmentResult = 'Rented' , Vacant = 'No' where ApartmentNo = '"
						+ apptno + "'";
				query1 = "update cs320stu141.application set Status = 'Rented' where Username = '"
						+ username + "' and ApartmentNo = '" + apptno + "'";
				PreparedStatement statement1 = (PreparedStatement) connection
						.prepareStatement(query);
				PreparedStatement statement2 = (PreparedStatement) connection
						.prepareStatement(query1);
				System.out.println(statement1.asSql());
				System.out.println(statement2.asSql());
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
				if (appdet.get(i).ApartmentNo.equals(apptno)) {
					appdet.get(i).setAppointmentResult("Rented");
					appdet.get(i).setVacant("No");
					// System.out.println("appdet status changed");
				}

			}

		}

		ArrayList<ApartmentDetails> appdet = (ArrayList<ApartmentDetails>) context
				.getAttribute("ApartmentDetails");
		request.setAttribute("appdet", appdet);

		ArrayList<Application> Application = (ArrayList<lease_management_system.Application>) context
				.getAttribute("ApplicationList");
		request.setAttribute("application", Application);

		response.sendRedirect("ManagerHome");

	}

}
