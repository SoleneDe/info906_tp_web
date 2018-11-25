package tp2WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp2EJB.Agency;
import tp2EJB.AgencyOperation;

/**
 * Servlet implementation class CreateAgencyServlet
 */
@WebServlet("/CreateAgencyServlet")
public class CreateAgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AgencyOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAgencyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		if("".equals(name)) {
			request.setAttribute("error", "Le nom de l'agence n'est pas renseigné.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {
			ejb.createAgency(name);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
