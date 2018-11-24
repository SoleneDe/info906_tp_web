package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp2EJB.Entry;
import tp2EJB.EntryOperation;

/**
 * Servlet implementation class DisplayEntryServlet
 */
@WebServlet("/DisplayEntryServlet")
public class DisplayEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EntryOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEntryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String idB = request.getParameter("idBacklog"); // pour lien de retour vers la backlog
		long id_long = Long.parseLong(id);
		
		Entry entry = ejb.getEntry(id_long);

		// Manage session to get username
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		request.setAttribute("entry", entry);
		request.setAttribute("idBacklog", idB);
		request.setAttribute("username", username);
		request.getRequestDispatcher("/DisplayEntry.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
