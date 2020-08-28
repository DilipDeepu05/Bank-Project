package Com.MyBank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Com.MyBank.Model;

public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		session.getAttribute("Accountnumber");
		int accountnumber=(int)session.getAttribute("Accountnumber");
	try
	{
		Model m=new Model();
		m.setAccountnumber(accountnumber);
		boolean b=m.applyLoan();
		if(b==true)
		{
			session.setAttribute("name", m.getName());
			session.setAttribute("emailid", m.getEmailid());
			response.sendRedirect("/MyBank/Loanproceed.jsp");
		}
		else
		{
			response.sendRedirect("/MyBank/Loanfailed.html");	
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
	}

}
