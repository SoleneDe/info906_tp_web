package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp2EJB.Backlog;
import tp2EJB.BacklogOperation;
import tp2EJB.Entry;

/**
 * Servlet implementation class DeleteEntryServlet
 */
@WebServlet("/DeleteEntryServlet")
public class DeleteEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BacklogOperation ejbB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEntryServlet() {
        super();
    }

	/**
	 * Delete an entry from a backlog
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idB = request.getParameter("idBacklog");
		String idE = request.getParameter("idEntry");

		if("".equals(idE)) {
			request.setAttribute("error", "Il manque l'id de l'entrée à supprimer.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {
			long idB_long;
			long idE_long = Long.parseLong(idE);
			HttpSession session = request.getSession();
			
			if (idB != null && !"".equals(idB))
			{
				idB_long = Long.parseLong(idB);
				
				// Manage session to get backlog id, to go back to the backlog
				session.setAttribute("idBacklog", idB);
			}
			else
			{
				// No backlog id in the request, look for it in the session
				idB_long = Long.parseLong((String) session.getAttribute("idBacklog"));
			}
			
			ejbB.deleteEntry(idB_long, idE_long);
	
			Backlog backlog = ejbB.getBacklog(idB_long);
			request.setAttribute("backlog", backlog);	
			request.getRequestDispatcher("/DisplayBacklog.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
