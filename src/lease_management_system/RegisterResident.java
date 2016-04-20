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
 * Servlet implementation class Register
 */
@WebServlet("/hw2/RegisterResident")
public class RegisterResident extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		ServletContext context = this.getServletContext();
		Hashtable errors = new Hashtable();

		if (context.getAttribute("Errors") == null) {
			context.setAttribute("Errors", errors);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("RegisterResident.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<UserDetails> lud1 = (List<UserDetails>) getServletContext()
				.getAttribute("userdetails");
		UserDetails ud1 = new UserDetails();

		Hashtable errors = new Hashtable();

		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String ConfirmPassword = request.getParameter("ConfirmPassword");
		String EmailID = request.getParameter("EmailID");
		String ContactNumber = request.getParameter("ContactNumber");
		String NoofPeople = request.getParameter("NoofPeople");
		String Occupation = request.getParameter("Occupation");
		String Type = request.getParameter("Type");
		String Preferences = request.getParameter("Preferences");
		String NeedfromDate = request.getParameter("NeedfromDate");
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		try {

			date = sdf.parse(NeedfromDate);

		} catch (ParseException e) {
			errors.put("err", "Invalid entry");
			doGet(request, response);
		}

		if ((Username == null || Username.equals(""))
				|| (Password == null || Password.equals(""))
				|| (ConfirmPassword == null || ConfirmPassword.equals(""))
				|| (!Password.equals(ConfirmPassword))
				|| (EmailID == null || EmailID.equals(""))
				|| (ContactNumber == null || ContactNumber.equals(""))
				|| (NoofPeople == null || NoofPeople.equals(""))
				|| (Occupation == null || Occupation.equals(""))
				|| (Type == null || Type.equals(""))
				|| (Preferences == null || Preferences.equals(""))
				|| (NeedfromDate == null || NeedfromDate.equals("")
				/*
				 * || !NeedfromDate .equals(sdf.format(date))
				 */)) {
			errors.put("err", "Invalid entry");
			response.sendRedirect("RegisterResident");
		} else if (Password.equals(ConfirmPassword)
				& NeedfromDate.equals(sdf.format(date))) {
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

				query = "insert into cs320stu141.user(Username,EmailID,Password,ConfirmPassword,ContactNumber,NoofPeople,Occupation,Type,Preferences,NeedfromDate) values (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement1 = connection
						.prepareStatement(query);
				statement1.setString(1, Username);
				statement1.setString(2, EmailID);
				statement1.setString(3, Password);
				statement1.setString(4, ConfirmPassword);
				statement1.setString(5, ContactNumber);
				statement1.setString(6, NoofPeople);
				statement1.setString(7, Occupation);
				statement1.setString(8, Type);
				statement1.setString(9, Preferences);
				statement1.setString(10, NeedfromDate);
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

				response.sendRedirect("Login");
			}
		}

		this.getServletContext().setAttribute("Errors", errors);

	}

}
