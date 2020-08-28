package Com.MyBank;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session= request.getSession();
		session.invalidate();
		response.sendRedirect("/MyBank/index.html");
	}

	
}
