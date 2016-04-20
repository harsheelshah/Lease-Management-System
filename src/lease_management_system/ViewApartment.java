package lease_management_system;

//import hw1.hw1_ApartmentDetails;

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
 * Servlet implementation class view
 */
@WebServlet("/hw2/ViewApartment")
public class ViewApartment extends HttpServlet {
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

				// System.out.println(id+" "+title+" "+author+" "+copies);

				ApartmentDetails b = new ApartmentDetails(ApartmentNo, Type,
						Facilities, MaximumPeople, Rent, Deposits, Vacant);
				l1.add(b);

			}
			ServletContext context = this.getServletContext();

			context.setAttribute("ApartmentDetails", l1);

			response.sendRedirect("ViewApartment.jsp");

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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
