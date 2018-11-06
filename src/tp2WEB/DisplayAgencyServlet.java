package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp2EJB.Agency;
import tp2EJB.AgencyOperation;

/**
 * Servlet implementation class DisplayAgencyServlet
 */
@WebServlet("/DisplayAgencyServlet")
public class DisplayAgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AgencyOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAgencyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long id_long = Long.parseLong(id);
		
		Agency agency = ejb.getAgency(id_long);
		
		// Manage session to get username
		String username = request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		request.setAttribute("agency", agency);
		request.setAttribute("username", username);
		request.getRequestDispatcher("/DisplayAgency.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
