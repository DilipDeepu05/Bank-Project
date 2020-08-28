package Com.MyBank;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	session=request.getSession();
	int accountnumber=(int)session.getAttribute("Accountnumber");
	try {
		Model m=new Model();
		m.setAccountnumber(accountnumber);
		boolean b=m.getCheckBalance();
		if(b==true)
		{
			System.out.print("aswdwq");
			session.setAttribute("Balance",m.getBalance());
			response.sendRedirect("/MyBank/Balancesuccess.jsp");
		}
		else
		{
			response.sendRedirect("/MyBank/Balancefail.html");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

	

}
