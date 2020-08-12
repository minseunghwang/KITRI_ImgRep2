package img.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.Service;
import img.service.ServiceImpl;
import model.Img;
import model.Rep;


/**
 * Servlet implementation class ImgList
 */
@WebServlet("/ImgList")
public class ImgList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		rep.service.Service rep_service = new rep.service.ServiceImpl();
		ArrayList<Img> products = service.getAll();
		for(Img i:products) {
			ArrayList<Rep> reps = rep_service.getRepsByImg_num(i.getNum());
			i.setReps(reps);
		}
		request.setAttribute("products", products);
		String path = "/imgBoard/imgList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
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
