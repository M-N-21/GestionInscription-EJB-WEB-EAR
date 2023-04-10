package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.IYearRemote;
import sn.isi.dao.YearImpl;
import sn.isi.entities.Year;

import java.io.IOException;


/**
 * Servlet implementation class YearServlet
 */
@WebServlet(urlPatterns = "/Year")
public class YearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private IYearRemote sdao = new YearImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Year s = new Year();
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
						request.setAttribute("success", "Year supprimé avec succès!");
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Year non supprimé avec succès!");
				}
					
			}
		}
		request.setAttribute("years", sdao.list(s));
		request.setAttribute("Year", s);
		request.getRequestDispatcher("/WEB-INF/year/yearlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Year s = new Year();
		s.setName(request.getParameter("name"));
		if(request.getParameter("id").equals(""))
			sdao.add(s);
		else
			s.setId(Integer.parseInt(request.getParameter("id")));
			sdao.update(s);
		response.sendRedirect("Year");
		doGet(request, response);
		
		
	}

}
