package controller;

import jakarta.ejb.EJB;   
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.CoursImpl;
import sn.isi.dao.ICoursRemote;
import sn.isi.entities.Cours;

import java.io.IOException;


/**
 * Servlet implementation class YearServlet
 */
@WebServlet(urlPatterns = "/Cours")
public class CoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private ICoursRemote sdao = new CoursImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cours s = new Cours();
		if (request.getParameter("page") != null) {
			if (request.getParameter("page").equals("edit")) {
				if (request.getParameter("id") != null) {
					int id = Integer.parseInt(request.getParameter("id"));
					s = sdao.get(id, s);
				}
			}else if(request.getParameter("page").equals("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					id = sdao.delete(id, s);
				
					if(id == 1) {
						request.setAttribute("success", "Cours supprimé avec succès!");
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Cours non supprimé avec succès!");
				}
					
			}
		}
		request.setAttribute("cours", sdao.list(s));
		request.setAttribute("Cours", s);
		request.getRequestDispatcher("/WEB-INF/cours/courslist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cours s = new Cours();
		s.setName(request.getParameter("name"));
		s.setProgramme(request.getParameter("programme"));
		if(request.getParameter("id").equals(""))
			sdao.add(s);
		else
			s.setId(Integer.parseInt(request.getParameter("id")));
			sdao.update(s);
		response.sendRedirect("Cours");
		doGet(request, response);
		
		
	}

}
