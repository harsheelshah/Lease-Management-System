package lease_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add
 */
@WebServlet("/hw2/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("AddApartment.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ApartmentDetails> ad = (List<ApartmentDetails>) getServletContext()
				.getAttribute("ApartmentDetails");
		ApartmentDetails uu1 = new ApartmentDetails();

		String ApartmentNo = request.getParameter("ApartmentNo");
		String Type = request.getParameter("Type");
		String Facilities = request.getParameter("Facilities");
		String MaximumPeople = request.getParameter("MaximumPeople");
		String Rent = request.getParameter("Rent");
		String Deposits = request.getParameter("Deposits");
		String Vacant = "Yes";
		String Available = "";
		String Appointments = "";
		if (Vacant == "Yes") {
			Appointments = "<a href='ViewAppointment.jsp?ApartmentNo="
					+ ApartmentNo + "'>View</a>";
		} else {
			Available = "<a href='#'>Make Available</a>";
		}

		String Operations = "<a href='RequestMapping?ApartmentNo="
				+ ApartmentNo + "'>Request for appointment</a>";
		String AppointmentDate = "";
		String AppointmentResult = "";

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

			query = "insert into cs320stu141.apartmentdetails(ApartmentNo,Type,Facilities,MaximumPeople,Rent,Deposits,Vacant) values (?,?,?,?,?,?,?)";
			PreparedStatement statement1 = connection.prepareStatement(query);
			statement1.setString(1, ApartmentNo);
			statement1.setString(2, Type);
			statement1.setString(3, Facilities);
			statement1.setString(4, MaximumPeople);
			statement1.setString(5, Rent);
			statement1.setString(6, Deposits);
			statement1.setString(7, Vacant);
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

			response.sendRedirect("ManagerHome");
		}
	}
}
