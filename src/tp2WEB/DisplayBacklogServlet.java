package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long id_long = Long.parseLong(id);
		
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
