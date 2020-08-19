package img.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rep;
import rep.service.Service;
import rep.service.ServiceImpl;

/**
 * Servlet implementation class RepController
 */
@WebServlet("/RepController")
public class RepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service service = new ServiceImpl();
		Rep rep = new Rep();
		rep.setWriter(request.getParameter("writer"));
		rep.setImg_num(Integer.parseInt(request.getParameter("img_num")));
		rep.setContent(request.getParameter("content"));
		service.addRep(rep);
		ArrayList<Rep> reps = service.getRepsByImg_num(rep.getImg_num());
		request.setAttribute("reps", reps);
		RequestDispatcher rd = request.getRequestDispatcher("/imgBoard/repList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
