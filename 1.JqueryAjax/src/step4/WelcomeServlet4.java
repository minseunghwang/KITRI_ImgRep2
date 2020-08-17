package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet4
 */
@WebServlet("/WelcomeServlet4")
public class WelcomeServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }
    private HashMap<String,String> nickMap = new HashMap<String,String>();
    
	@Override
	public void init() throws ServletException {
		nickMap.put("백승석", "백박사");
		nickMap.put("장여진", "구리스탈");
		nickMap.put("이준우", "오토플러쉬");
		nickMap.put("이진우", "회식킹");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		// 부분 업데이트를 위해 캐시(임시메모리영역)사용 금지
		// response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		boolean flag = nickMap.containsKey(name);
		if(flag) {
			out.println(name+"님의 별명은 : " + nickMap.get(name));
		} else {
			out.println("대응되는 데이터 없음");
		}
		
		out.println("");
		out.println("서버응답 데이터");
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
