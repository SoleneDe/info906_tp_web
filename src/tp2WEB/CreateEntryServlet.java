package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp2EJB.BacklogOperation;
import tp2EJB.Entry;
import tp2EJB.EntryOperation;

/**
 * Servlet implementation class CreateEntryServlet
 */
@WebServlet("/CreateEntryServlet")
public class CreateEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EntryOperation ejbE;
	@EJB
	private BacklogOperation ejbB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEntryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idB = request.getParameter("idBacklog");
		String priority = request.getParameter("priority");
		String estimation = request.getParameter("estimation");
		String description = request.getParameter("description");
		
		String name = (String) request.getSession().getAttribute("username"); 
		
		long idB_long = Long.parseLong(idB);
		int priority_int = Integer.parseInt(priority);
		int estimation_int = Integer.parseInt(estimation);
		
		Entry entry = ejbE.createEntry(name, priority_int, estimation_int, description);
		
		ejbB.addEntry(idB_long, entry);

		request.setAttribute("entry", entry);	
		request.getRequestDispatcher("/DisplayEntry.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
