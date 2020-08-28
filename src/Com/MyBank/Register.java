package Com.MyBank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
;		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
	int Customerid=Integer.parseInt(request.getParameter("Customerid"));
		
		
		String p1=request.getParameter("accountnumber");
		int accountnumber=Integer.valueOf(p1);
		
		String p2=request.getParameter("creditnumber");
		int creditnumber=Integer.valueOf(p2);
		String p3=request.getParameter("balance");
		int balance=Integer.valueOf(p3);
		try {
			Model m=new Model();
			m.setAccountnumber(accountnumber);
			m.setBalance(balance);
			m.setCreditnumber(creditnumber);
			m.setCustomerid(Customerid);
			m.setPassword(password);
			m.setEmailid(email);
			m.setName(name);
	boolean b=m.insert();
	if(b==true)
	{
		response.sendRedirect("/MyBank/Index1.html");
	}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
