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

/**
 * Servlet implementation class DisplayBacklogServlet
 */
@WebServlet("/DisplayBacklogServlet")
public class DisplayBacklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BacklogOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBacklogServlet() {
        super();
    }

	/**
	 * Display a backlog (with the list of all its entries)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long id_long;
		HttpSession session = request.getSession();
		
		if (id != null && !"".equals(id))
		{
			id_long = Long.parseLong(id);
			
			// Manage session to get backlog id
			// When using links to go back to the backlog
			session.setAttribute("idBacklog", id);
		}
		else
		{
			id_long = Long.parseLong((String) session.getAttribute("idBacklog"));
		}
		
		Backlog backlog = ejb.getBacklog(id_long);
		
		request.setAttribute("backlog", backlog);
		request.getRequestDispatcher("/DisplayBacklog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
