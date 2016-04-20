package lease_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRentHistory
 */
@WebServlet("/hw2/ShowRentHistory")
public class ShowRentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowRentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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

			query = "Select * from cs320stu141.application where Status = 'Rented' and RentPaid is not null order by ApartmentNo,month";
			// query1 =
			// "Select * from cs320stu141.application where Vacant = 'No'";
			resultSet = statement.executeQuery(query);

			List<Application> l1 = new ArrayList<Application>();

			while (resultSet.next()) {

				String ApartmentNo = resultSet.getString("ApartmentNo");
				String Username = resultSet.getString("Username");
				String Rent = resultSet.getString("Rent");
				String RentPaid = resultSet.getString("RentPaid");
				String Month = resultSet.getString("month");
				String Year = resultSet.getString("year");
				// System.out.println(id+" "+title+" "+author+" "+copies);

				Application b = new Application(ApartmentNo, Username, Rent,
						RentPaid, Month, Year);
				l1.add(b);

			}
			ServletContext context = this.getServletContext();

			context.setAttribute("Application", l1);

			response.sendRedirect("ShowRentHistory.jsp");

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
	}

}
