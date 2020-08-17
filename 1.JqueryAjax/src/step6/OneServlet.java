package step6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneServlet
 */
@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private HashMap<String, String> map = new HashMap<String, String>();
    public void init() {
    	map.put("1", "1200원");
    	map.put("2", "720원");
    	map.put("3", "1000원");
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 부분 업데이트를 위해 캐시(임시메모리영역)사용 금지
		 response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		System.out.println("doGet()...");
		String line = request.getParameter("line");
		if(map.containsKey(line)) {
			out.print(map.get(line));
		} else {
			out.print("호선 입력하세요");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
