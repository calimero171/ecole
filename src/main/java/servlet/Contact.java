package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.AccessBdd;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccessBdd bd=new AccessBdd(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * methode qui recupere le post du formulaire
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CHAMP_EMAIL="email"; 
		String CHAMP_MSG="msg"; 
	    String email = request.getParameter(CHAMP_EMAIL);
	    String msg = request.getParameter(CHAMP_MSG);
	    bd.inscrireUser( email, msg);
	    
		System.out.println("jo "+email+" "+msg);

		//doGet(request, response);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/OK.jsp").forward(request, response);
	}

}
