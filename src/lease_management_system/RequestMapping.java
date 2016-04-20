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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestMapping
 */
@WebServlet("/hw2/RequestMapping")
public class RequestMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String Username = request.getParameter("username");
		String ApartmentNo = request.getParameter("aptno");
		String Rent = request.getParameter("rent");

		// System.out.println(Username);
		// System.out.println(ApartmentNo);

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

			query = "insert into cs320stu141.application(Username,ApartmentNo,Rent) values (?,?,?)  ";
			PreparedStatement statement1 = connection.prepareStatement(query);
			statement1.setString(1, Username);
			statement1.setString(2, ApartmentNo);
			statement1.setString(3, Rent);

			statement1.executeUpdate();

			resultSet = statement1.executeQuery(query);

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

			ServletContext context = this.getServletContext();

			ArrayList<Application> Application = (ArrayList<lease_management_system.Application>) context
					.getAttribute("ApplicationList");
			Application e = new Application();

			e.setApartmentNo(ApartmentNo);
			e.setUsername(Username);

			Application.add(e);

			response.sendRedirect("LookUpApartment");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
