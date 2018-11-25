package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp2EJB.Entry;
import tp2EJB.EntryOperation;

/**
 * Servlet implementation class CreateCommentServlet
 */
@WebServlet("/CreateCommentServlet")
public class CreateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EntryOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCommentServlet() {
        super();
    }

	/**
	 * Add a new comment in an entry
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idE = request.getParameter("idEntry");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		if("".equals(idE) || "".equals(name) || "".equals(content)) {
			request.setAttribute("error", "Un champs n'est pas renseign�.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {
			long idE_long = Long.parseLong(idE);
			
			ejb.addComment(idE_long, name, content);
			
			Entry entry = ejb.getEntry(idE_long);
			
			request.setAttribute("entry", entry);	
			request.getRequestDispatcher("/DisplayEntry.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
