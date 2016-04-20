package lease_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LookUpApartment
 */
@WebServlet("/hw2/LookUpApartment")
public class LookUpApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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

			query = "Select * from cs320stu141.apartmentdetails";

			resultSet = statement.executeQuery(query);

			List<ApartmentDetails> l1 = new ArrayList<ApartmentDetails>();

			while (resultSet.next()) {

				String ApartmentNo = resultSet.getString("ApartmentNo");
				String Type = resultSet.getString("Type");
				String Facilities = resultSet.getString("Facilities");
				String MaximumPeople = resultSet.getString("MaximumPeople");
				String Rent = resultSet.getString("Rent");
				String Deposits = resultSet.getString("Deposits");
				String Vacant = resultSet.getString("Vacant");
				String AppointmentDate = resultSet.getString("AppointmentDate");
				String AppointmentResult = resultSet
						.getString("AppointmentResult");

				// System.out.println(id+" "+title+" "+author+" "+copies);

				ApartmentDetails b = new ApartmentDetails(ApartmentNo, Type,
						Facilities, MaximumPeople, Rent, Deposits, Vacant,
						AppointmentDate, AppointmentResult);
				l1.add(b);

			}
			ServletContext context = this.getServletContext();

			context.setAttribute("appdet", l1);

			// out.println("</body></html>");

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

		ServletContext context = this.getServletContext();

		/*
		 * ArrayList<ApartmentDetails> appdet= (ArrayList<ApartmentDetails>)
		 * context.getAttribute("ApartmentDetails");
		 * request.setAttribute("appdet", appdet);
		 */

		ArrayList<Application> Application = (ArrayList<lease_management_system.Application>) context
				.getAttribute("ApplicationList");
		request.setAttribute("application", Application);

		request.getRequestDispatcher("LookUpApartment.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = this.getServletContext();
		String aptno = request.getParameter("aptno");
		String username = request.getParameter("username");
		String rescheduledate = request.getParameter("rescheduledate");

		/*
		 * System.out.println("Hi"); System.out.println(aptno);
		 * System.out.println(username); System.out.println(rescheduledate);
		 */

		if (request.getParameter("accept") != null) {

			ArrayList<Application> appList = (ArrayList<Application>) context
					.getAttribute("ApplicationList");

			for (Application a : appList) {
				if (a.getApartmentNo().equals(aptno)
						&& a.getUsername().equals(username)) {
					a.setStatus("Accepted");
				}
			}

			ArrayList<ApartmentDetails> appdet = (ArrayList<ApartmentDetails>) context
					.getAttribute("ApartmentDetails");

			for (int i = 0; i < appdet.size(); i++) {
				// for (int j=0;j<appList.size();j++){
				if (appdet.get(i).ApartmentNo.equals(aptno))
					// && username.equals(appList.get(j).getUsername())){
					appdet.get(i).setAppointmentResult("Accepted");

				// }
				// }
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

				query = "update cs320stu141.apartmentdetails set AppointmentResult = 'Accepted' where ApartmentNo = '"
						+ aptno + "'";
				query1 = "update cs320stu141.application set Status = 'Accepted' where Username = '"
						+ username + "' and ApartmentNo = '" + aptno + "'";
				PreparedStatement statement1 = connection
						.prepareStatement(query);
				PreparedStatement statement2 = connection
						.prepareStatement(query1);
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

		}

		if (request.getParameter("reject") != null) {

			ArrayList<Application> appList = (ArrayList<Application>) context
					.getAttribute("ApplicationList");

			for (Application a : appList) {
				if (a.getApartmentNo().equals(aptno)
						&& a.getUsername().equals(username)) {
					a.setStatus("Denied");
					a.setRuledOutDate(a.getRescheduledDate());
				}
			}

			ArrayList<ApartmentDetails> appdet = (ArrayList<ApartmentDetails>) context
					.getAttribute("ApartmentDetails");

			for (int i = 0; i < appdet.size(); i++) {
				if (appdet.get(i).ApartmentNo.equals(aptno)) {
					appdet.get(i).setAppointmentResult("Denied");
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
				String query2 = "";

				query = "update cs320stu141.apartmentdetails set AppointmentResult = 'Denied' where ApartmentNo = '"
						+ aptno + "'";
				query1 = "update cs320stu141.application set Status = 'Denied',RuledOutDate = RescheduledDate where Username = '"
						+ username + "' and ApartmentNo = '" + aptno + "'";
				query2 = "update cs320stu141.application set RuledOutDate = RescheduledDate where Username = '"
						+ username
						+ "' and ApartmentNo = '"
						+ aptno
						+ "' and Status = 'Denied'";

				PreparedStatement statement1 = connection
						.prepareStatement(query);
				PreparedStatement statement2 = connection
						.prepareStatement(query1);
				PreparedStatement statement3 = connection
						.prepareStatement(query2);
				statement1.executeUpdate();
				statement2.executeUpdate();
				statement3.executeUpdate();

				resultSet = statement1.executeQuery(query);
				resultSet = statement2.executeQuery(query1);
				resultSet = statement3.executeQuery(query2);

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

		}

		// response.sendRedirect("Accept");
		doGet(request, response);
	}
}