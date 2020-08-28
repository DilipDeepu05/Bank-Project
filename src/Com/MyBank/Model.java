package Com.MyBank;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
 private int Accountnumber;

 private int Creditnumber;

 
public int getCreditnumber() {
	return Creditnumber;
}
public void setCreditnumber(int creditnumber) {
	Creditnumber = creditnumber;
}
private int Accountnumber1;
 private String Password;
 private int Balance;
 private String Emailid;
private int Customerid;
 private String Newpassword;
 private String Name;
 ArrayList<Integer> al=new ArrayList<Integer>();

 ArrayList<Integer> al1=new ArrayList<Integer>();

 ArrayList<Integer> al2=new ArrayList<Integer>();

 public int getAccountnumber() {
	return Accountnumber;
}
public void setAccountnumber(int accountnumber) {
	Accountnumber = accountnumber;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public int getCustomerid() {
	return Customerid;
}
public int getAccountnumber1() {
	return Accountnumber1;
}
public void setAccountnumber1(int accountnumber1) {
	Accountnumber1 = accountnumber1;
}
public void setCustomerid(int phonenumber) {
	Customerid = phonenumber;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

public String getNewpassword() {
	return Newpassword;
}
public void setNewpassword(String newpassword) {
	Newpassword = newpassword;
}
public int getBalance() {
	return Balance;
}
public void setBalance(int balance) {
	Balance = balance;
}
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
String url="jdbc:mysql://localhost:3306/project";
	String userid="root";
	String password1="root";
private Connection con;
private PreparedStatement pstmt;
private ResultSet res;

public boolean login() throws SQLException
{
	String s="select Accountnumber from BankApp where customerid=? and password=?";
	pstmt= con.prepareStatement(s);
	pstmt.setInt(1, Customerid);
	pstmt.setString(2, Password);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		Accountnumber= res.getInt(1);
		return true;
	}
	return false;
	
}
 public Model() throws ClassNotFoundException, SQLException
 {
	 Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver is loaded");
		con=DriverManager.getConnection(url,userid,password1);
		System.out.println("Connection is established"); 
 }
public boolean getCheckBalance() throws SQLException {
	
	String s="select balance from bankapp where accountnumber=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, Accountnumber);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		Balance=res.getInt(1);
		return true;
	}
	return false;
}
public boolean applyLoan() throws Exception {
	String s="select * from bankapp where accountnumber=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, Accountnumber);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		Name=res.getString(3);
		Emailid=res.getString(6);
		return true;
	}
	
	
	return false;
}
public boolean changePassword() throws Exception {
	String s="update bankapp set password=? where accountnumber=? and password=?";
	pstmt=con.prepareStatement(s);
	
	pstmt.setString(1, Newpassword);
	pstmt.setInt(2, Accountnumber);
	pstmt.setString(3,Password);
	int x=pstmt.executeUpdate();
	if(x>0)
	{
		return true;
	}
	return false;
}
public boolean transfer() throws Exception {
	String s="select * from bankapp where accountnumber=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, Accountnumber1);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
	String s1="Update bankapp set balance=balance-? where accountnumber=?";
	pstmt=con.prepareStatement(s1);
	pstmt.setInt(1,Balance);
	pstmt.setInt(2, Accountnumber);
	int x=pstmt.executeUpdate();
	if(x>0)
	{
		String s2="Update bankapp set balance=balance+? where accountnumber=?";
		pstmt=con.prepareStatement(s2);
		pstmt.setInt(1,Balance);
		pstmt.setInt(2, Accountnumber1);
		int y=pstmt.executeUpdate();
		if(y>0) {
		String s3="Insert into getstatment values(?,?,?)";
		pstmt=con.prepareStatement(s3);
		pstmt.setInt(1, Accountnumber);
		pstmt.setInt(2, Accountnumber1);
		pstmt.setInt(3, Balance);
		int z=pstmt.executeUpdate();
		if(z>0)
		{
			return true;
		}
		}
else 
		{
			return false;
		}
	}
	else
	{
		return false;
	}
			
	}
	

	
	return false;
}
public ArrayList<Integer> getStatment() throws Exception {
	
	String s="select * from getstatment where accountnumber=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, Accountnumber);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		al.add(res.getInt(1));
		al1.add(res.getInt(2));
		al2.add(res.getInt(3));
	}
	return al;
}
public boolean forgetpassword() throws Exception {
	String s="update bankapp set password=? where emailid=?";
	pstmt=con.prepareStatement(s);
	pstmt.setString(1, Password);
	pstmt.setString(2, Emailid);
	int a=pstmt.executeUpdate();
	if(a>0)
	{
		return true;
	}
	return false;
}
public boolean insert() throws Exception {
	String s="insert into bankapp values(?,?,?,?,?,?,?)";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, Accountnumber);
	pstmt.setString(2, Name);
	pstmt.setInt(3, Customerid);
	pstmt.setInt(4, Balance);
	pstmt.setString(5, Emailid);
	pstmt.setInt(6, Creditnumber);
	pstmt.setString(7, Password);
	int b=pstmt.executeUpdate();
	if(b>0) {
		return true;
	}
	return false;
}

}
