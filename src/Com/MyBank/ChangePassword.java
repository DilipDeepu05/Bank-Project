package Com.MyBank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Com.MyBank.Model;

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String npwd=request.getParameter("npwd");
		String cupwd=request.getParameter("cupwd");
	HttpSession session =request.getSession();
	int accountnumber=(int)session.getAttribute("Accountnumber");
	try {
		Model m=new Model();
		m.setAccountnumber(accountnumber);
		m.setPassword(cupwd);
		m.setNewpassword(npwd);
		boolean b=m.changePassword();
		if(b==true)
		{
			response.sendRedirect("/BankProject/Changepasswordsuccess.html");
		}
		else
		{
			response.sendRedirect("/BankProject/Changepasswordfail.html");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	

}
