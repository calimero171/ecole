package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class accueil
 */
public class accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int  compteur=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(true);
				
		String varSession="Je suis dans la session";
		session.setAttribute("varSession", varSession);
		
		User buoy=new User(0L,"buoy","toto","buoy@gmail.com");
		request.setAttribute("buoy",buoy);
			
		
		System.out.println("accueil");
		String paramName=request.getParameter("name");
		String comment="je suis un commentaire ecrit par "+paramName;
		request.setAttribute("myComment", comment);	
	   					
		this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	     	
	
	}


}
