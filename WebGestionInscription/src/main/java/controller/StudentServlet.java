package controller;

import jakarta.ejb.EJB; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.IStudentLocal;
import sn.isi.dao.IStudentRemote;
import sn.isi.dao.StudentImpl;
import sn.isi.entities.Student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(urlPatterns = "/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private IStudentRemote sdao = new StudentImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = new Student();
		if (request.getParameter("page") != null) {
			if (request.getParameter("page").equals("edit")) {
				if (request.getParameter("id") != null) {
					int id = Integer.parseInt(request.getParameter("id"));
					s = sdao.get(id, s);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String formattedDate = formatter.format(s.getBirthday());
					request.setAttribute("date", formattedDate);
				}
			}else if(request.getParameter("page").equals("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					id = sdao.delete(id, s);
				
					if(id == 1) {
						request.setAttribute("success", "Student supprimé avec succès!");
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Student non supprimé avec succès!");
				}
					
			}
		}
		request.setAttribute("students", sdao.list(s));
		request.setAttribute("student", s);
		request.getRequestDispatcher("/WEB-INF/student/studentlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.setFirstName(request.getParameter("firstname"));
		s.setLastName(request.getParameter("lastname"));
		s.setPhone(request.getParameter("phone"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = sdf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setBirthday(d);
		if(request.getParameter("id").equals(""))
			sdao.add(s);
		else
			s.setId(Integer.parseInt(request.getParameter("id")));
			sdao.update(s);
		response.sendRedirect("Student");
		doGet(request, response);
		
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
}
