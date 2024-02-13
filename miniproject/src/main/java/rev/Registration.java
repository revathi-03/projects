package rev;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/register")


public class Registration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter p=response.getWriter();
	
	String uname=request.getParameter("first");
	String email=request.getParameter("email");
	String pass=request.getParameter("password");
	String contact=request.getParameter("mobile");
	String gender=request.getParameter("gender");
	String add=request.getParameter("address");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf","root","root");
	PreparedStatement st= cnct.prepareStatement("insert into register(username,email,userpass,contact,gender,address)values(?,?,?,?,?,?)");
	  
	    st.setString(1,uname);
	    st.setString(2,email);
	    st.setString(3,pass);
	    st.setString(4,contact);
	    st.setString(5,gender);
	    st.setString(6,add);
	                                                                                            
	    int str=st.executeUpdate();
	if(str>0)
	{
		
		RequestDispatcher rd=request.getRequestDispatcher("/login1.html");
	rd.include(request,response);
		//response.sendRedirect("http://localhost:8082/miniproject/login1.html");
		}
		else{
	p.print("not register properly");
	}
	st.close();
	cnct.close();
	
		}
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
  
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
