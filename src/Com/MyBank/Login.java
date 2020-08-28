package Com.MyBank;

	import java.io.IOException;




	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import Com.MyBank.Model;





	public class Login extends HttpServlet {
		private static final long serialVersionUID = 1L;

		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession(true);
			
			int custId=Integer.parseInt(request.getParameter("custid"));
			String pwd=request.getParameter("pwd");
			try
			{
				Model m=new Model();
				m.setCustomerid(custId);
				m.setPassword(pwd);
				boolean b=m.login();
				if(b==true)
				{
					session.setAttribute("Accountnumber", m.getAccountnumber());
					response.sendRedirect("/MyBank/Home.html");
					
				}
				else
				{
					response.sendRedirect("/MyBank/Error.html");
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

