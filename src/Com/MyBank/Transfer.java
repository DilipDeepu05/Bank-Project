package Com.MyBank;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.MyBank.Model;

public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("5656565");
		String s=request.getParameter("accn01");
		int accountnumber1=Integer.parseInt(s);
		String s1=request.getParameter("amt");
		int amount=Integer.parseInt(s1);
		session=request.getSession();
		int accountnumber=(int)session.getAttribute("Accountnumber");
		try {
			Model m=new Model();
			m.setAccountnumber(accountnumber);
			m.setBalance(amount);
			m.setAccountnumber1(accountnumber1);
			boolean b=m.transfer();
			if(b==true)
			{
				session.setAttribute("bal",m.getBalance());
				response.sendRedirect("/MyBank/Transfersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/MyBank/Transferfail.html");
			}
		}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	}

