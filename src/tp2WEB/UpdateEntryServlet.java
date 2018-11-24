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
 * Servlet implementation class UpdateEntryServlet
 */
@WebServlet("/UpdateEntryServlet")
public class UpdateEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EntryOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEntryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idE = request.getParameter("idEntry");
		String idB = request.getParameter("idBacklog"); // pour lien de retour vers la backlog
		String name = request.getParameter("name");
		String priority = request.getParameter("priority");
		String estimation = request.getParameter("estimation");
		String description = request.getParameter("description");
		
		long idE_long = Long.parseLong(idE);
		int priority_int, estimation_int;

		if (priority == null)
		{
			priority_int = -1;
		}
		else
		{
			priority_int = Integer.parseInt(priority);
		}
		if (estimation == null)
		{
			estimation_int = -1;
		}
		else
		{
			estimation_int = Integer.parseInt(estimation);
		}
		
		Entry entry = ejb.updateEntry(idE_long, name, priority_int, estimation_int, description);

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