

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="RegisterSession",urlPatterns= {"/RegisterSession"})
public class RegisterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/attendance";
    static final String USER = "root";
    static final String PASS = "1490";

    public RegisterServlet()
    {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("AERo");
        int uid=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String dob=request.getParameter("dob");
        String mobile=request.getParameter("mobile");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String emailid=request.getParameter("emailid");

        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = null;
            out.println("AER");
            String sql;
            sql="create database if not exists attendance;use attendance;";
            sql+="create table if not exists staff( id int not null,name varchar(255) not null,dob varchar(255) not null,mobile varchar(255) not null, username varchar (255) not null unique,password varchar (255) not null,emailid varchar(255) not null);";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("OPO");
            stmt.executeQuery(sql);
            out.println("LOL");
            sql="insert into staff values (?,?,?,?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,uid);
            stmt.setString(2, name);
            stmt.setString(3, dob);
            stmt.setString(4, mobile);
            stmt.setString(5,username);
            stmt.setString(6, password);
            stmt.setString(7, emailid);
            int rows=stmt.executeUpdate();
            out.println(rows+" row inserted");

            sql="select * from staff;";
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                int temp=Integer.parseInt(rs.getString("id"));
                if(uid==temp)
                {
                    out.println("Successfully Registered");
                    break;
                }
            }

        }
        catch(Exception e)
        {
        	out.println("KKK0"+e);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
