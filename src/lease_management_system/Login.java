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
 * Servlet implementation class Login
 */
@WebServlet("/hw2/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ServletContext context = this.getServletContext();

		List<UserDetails> l1 = new ArrayList<UserDetails>();
		List<ApartmentDetails> appdet = new ArrayList<ApartmentDetails>();
		List<Application> applicationList = new ArrayList<Application>();
		getServletContext().setAttribute("ApplicationList", applicationList);
		/*
		 * UserDetails u1 = new UserDetails();
		 * 
		 * u1.setUsername("jdoe"); u1.setPassword("admin");
		 * u1.setEmailID("jdoe@localhost.com");
		 * 
		 * l1.add(u1); UserDetails a = new UserDetails();
		 * 
		 * a.setUsername("a"); a.setPassword("a"); a.setEmailID("a");
		 * a.setContactNumber("25"); l1.add(a);
		 * getServletContext().setAttribute("userdetails",l1);
		 * 
		 * if(context.getAttribute("ApartmentDetails")== null){
		 * 
		 * List<ApartmentDetails> appdet = new ArrayList<ApartmentDetails>();
		 * 
		 * appdet.add(new ApartmentDetails("1", "1BHK", "AC", "2", "1000$",
		 * "2000$", "1", null, null,null,null,null));
		 * 
		 * getServletContext().setAttribute("ApartmentDetails",appdet); }
		 */
		Hashtable errors = new Hashtable();
		if (context.getAttribute("Errors") == null) {
			context.setAttribute("Errors", errors);
		}

	}

	/*
	 * List<Application> applicationList=new ArrayList<Application>();
	 * applicationList.add(new
	 * Application(11111,"aaaaaa","a1","a1","a1","a1","11010101010"));
	 * 
	 * getServletContext().setAttribute("ApplicationList", applicationList); }
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

			query = "Select * from cs320stu141.user";

			resultSet = statement.executeQuery(query);

			List<UserDetails> l1 = new ArrayList<UserDetails>();

			while (resultSet.next()) {

				String Username = resultSet.getString("Username");
				String Password = resultSet.getString("Password");
				String EmailID = resultSet.getString("EmailID");

				// System.out.println(Username+" "+Password+" "+EmailID);

				UserDetails b = new UserDetails(Username, Password, EmailID);
				l1.add(b);

			}
			ServletContext context = this.getServletContext();

			context.setAttribute("userdetails", l1);

			response.sendRedirect("Login.jsp");

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
		// TODO Auto-generated method stub
		String url = null;
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		List<UserDetails> lud = (List<UserDetails>) getServletContext()
				.getAttribute("userdetails");

		String EmailID = request.getParameter("EmailID");
		String Password = request.getParameter("Password");
		// System.out.println("Email-->"+EmailID+"    PAssword--->"+Password );

		HttpSession session = request.getSession();
		Hashtable errors = new Hashtable();

		if (EmailID == null || Password == null || EmailID.equals("")
				|| Password.equals("")) {
			errors.put("err", "Please enter EmailID or Password");
		}

		else {
			for (UserDetails u1 : lud) {

				if (u1.getEmailID().equals(EmailID)
						&& u1.getPassword().equals(Password)) {

					if (u1.getEmailID().equals("jdoe@localhost.com")) {
						session.setAttribute("Username", u1.getUsername());
						url = "ManagerHome";

					} else {
						session.setAttribute("Username", u1.getUsername());
						url = "LookUpApartment";

					}
				} else {
					errors.put("invalid", "EmailID or Password is invalid");
				}
			}
		}
		if (url != null) {
			response.sendRedirect(url);
		} else {
			this.getServletContext().setAttribute("Errors", errors);
			doGet(request, response);

		}

	}
}
