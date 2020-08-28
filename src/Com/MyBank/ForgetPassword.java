package Com.MyBank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String npwd=request.getParameter("npwd");
		session=request.getSession();
		String email=(String)session.getAttribute("email");
		try {
			Model m=new Model();
			m.setEmailid(email);
			m.setPassword(npwd);
			boolean b=m.forgetpassword();
			if(b==true)
			{
				response.sendRedirect("/MyBank/success.html");
			}
			else {
				response.sendRedirect("/MyBank/failure.html");
			}
		}catch(Exception e) {
		e.printStackTrace();
	}

}
}
