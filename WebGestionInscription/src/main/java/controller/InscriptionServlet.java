package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.ICoursRemote;
import sn.isi.dao.IInscriptionRemote;
import sn.isi.dao.IStudentRemote;
import sn.isi.dao.IYearRemote;
import sn.isi.dao.InscriptionImpl;
import sn.isi.dao.StudentImpl;
import sn.isi.dao.YearImpl;
import sn.isi.entities.Cours;
import sn.isi.entities.Inscription;
import sn.isi.entities.Student;
import sn.isi.entities.Year;

import java.io.IOException;


/**
 * Servlet implementation class YearServlet
 */
@WebServlet(urlPatterns = "/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private IInscriptionRemote sdao = new InscriptionImpl();
	@EJB
	private ICoursRemote cdao;
	@EJB
	private IYearRemote ydao;
	@EJB
	private IStudentRemote idao = new StudentImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Inscription s = new Inscription();
		if (request.getParameter("page") != null) {
			if (request.getParameter("page").equals("edit")) {
				if (request.getParameter("id") != null) {
					int id = Integer.parseInt(request.getParameter("id"));
					s = sdao.get(id, s);
				}
			}else if(request.getParameter("page").equals("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				//try {
					id = sdao.delete(id, s);
				
					if(id == 1) {
						request.setAttribute("success", "Inscription supprimé avec succès!");
						
					}
				//} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Inscription non supprimé avec succès!");
				//}
					
			}
		}
		request.setAttribute("inscriptions", sdao.list(s));
		request.setAttribute("students", idao.list(new Student()));
		request.setAttribute("cours", cdao.list(new Cours()));
		request.setAttribute("years", ydao.list(new Year()));
		request.setAttribute("Inscription", s);
		request.getRequestDispatcher("/WEB-INF/inscription/inscriptionlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Inscription s = new Inscription();
		s.setDetails((request.getParameter("details")));
		s.setStudent(idao.get(Integer.parseInt(request.getParameter("student")), new Student()));
		s.setCours(cdao.get(Integer.parseInt(request.getParameter("cours")), new Cours()));
		s.setYear(ydao.get(Integer.parseInt(request.getParameter("year")), new Year()));
		if(request.getParameter("id").equals(""))
			sdao.add(s);
		else
			s.setId(Integer.parseInt(request.getParameter("id")));
			sdao.update(s);
		response.sendRedirect("Inscription");
		doGet(request, response);
		
		
	}

}
