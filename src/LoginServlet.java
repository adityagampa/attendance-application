import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String n=req.getParameter("username");
		String p=req.getParameter("password1");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int flag=0;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","1490");

		String sql="select username,password from staff;";
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next())
		{
			String a=rs.getString("username");
			String b=rs.getString("password");
			if((a.equals(n))&&(b.equals(p)))
			{
				out.println("welcome");
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/stafflogin.html");
		    rd.include(req, res);
		}
		else if(flag==0)
		{

				out.println("sorry enter correct details");
				RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			    rd.include(req, res);
		}

		}catch(SQLException se){
      		se.printStackTrace();
   		}catch(Exception e){
      		e.printStackTrace();
   		}
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		doGet(req,res);
	}
}