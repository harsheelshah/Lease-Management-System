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

/**
 * Servlet implementation class PayRent
 */
@WebServlet("/hw2/PayRent")
public class PayRent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

			query = "Select * from cs320stu141.application where Status = 'Rented'";
			// query1 =
			// "Select * from cs320stu141.application where Vacant = 'No'";
			resultSet = statement.executeQuery(query);

			List<Application> l1 = new ArrayList<Application>();

			while (resultSet.next()) {

				String ApartmentNo = resultSet.getString("ApartmentNo");

				String Rent = resultSet.getString("Rent");

				String Username = resultSet.getString("Username");
				// System.out.println(ApartmentNo+" "+Rent+" "+Username);

				Application b = new Application(Username, Rent, ApartmentNo);
				l1.add(b);

			}
			ServletContext context = this.getServletContext();

			context.setAttribute("Application", l1);

			response.sendRedirect("PayRent.jsp");

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String apartmentNo = request.getParameter("apartmentNo");
		String username = request.getParameter("username");
		String RentPaid = request.getParameter("RentPaid");
		// String RentPaid1 =
		// request.getParameter("username"+"_"+"apartmentNo");
		// String RentPaid = "RentPaid"+"_"+apartmentNo;

		String month = request.getParameter("month");
		String year = request.getParameter("year");

		// System.out.println("RentPaid"+"_"+"apartmentNo");
		System.out.println(RentPaid);
		// System.out.println(RentPaid1);
		System.out.println(month);
		System.out.println(year);
		System.out.println(username);
		System.out.println(apartmentNo);

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

			query = "update cs320stu141.application set RentPaid = '"
					+ RentPaid + "' , month = '" + month + "' , year = '"
					+ year + "' where Username = '" + username
					+ "' and ApartmentNo = '" + apartmentNo + "' ";
			PreparedStatement statement1 = connection.prepareStatement(query);

			statement1.executeUpdate();

			resultSet = statement.executeQuery(query);

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

			response.sendRedirect("ViewApartment");
		}
	}

}
