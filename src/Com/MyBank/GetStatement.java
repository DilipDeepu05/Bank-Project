package Com.MyBank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		int accountnumber=(int)session.getAttribute("Accountnumber");

		try {
		Model m=new Model();
		m.setAccountnumber(accountnumber);
		ArrayList al=m.getStatment();
		if(al.isEmpty()==true)
		{
			response.sendRedirect("/MyBank/StatmentFail.html");
		}
		else
		{
			session.setAttribute("al", m.al);
			session.setAttribute("al1", m.al1);
			session.setAttribute("al2", m.al2);
			response.sendRedirect("/MyBank/Statmentsuccess.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
