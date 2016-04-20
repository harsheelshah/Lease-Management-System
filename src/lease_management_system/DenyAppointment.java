package lease_management_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DenyAppointment
 */
@WebServlet("/hw2/DenyAppointment")
public class DenyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("User rejected the scheduled appointment date");
		out.println("Please enter another time");
		out.println("<html><head><body><table>");
		out.println("<tr><td>AppointmentDate</td><td><input type='text' name='ApartmentDate' /> </td></tr>");
		out.println("</table></body></head></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
