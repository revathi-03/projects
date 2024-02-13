package rev;
//import rev.UserDTO;


//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//import jakarta.servlet.RequestDispatcher;

public class UserDAO {
	
	public UserDTO userinfo(String email) {
		
		UserDTO dto=new UserDTO();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf","root","root");		
		  
		  Statement stmt = cnct.createStatement();
			ResultSet as = stmt.executeQuery("select * from register where email='" + email+ "'");
		  while (as.next()) {
		    dto.setUsername(as.getString("username"));
		   dto.setEmail(as.getString("email"));
		   dto.setContact(as.getInt("contact"));
		  } 
		   
		 
		
	as.close();
		cnct.close();
		
			}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return dto;
	
	} 
public boolean validate(String email, String password) {
		
		boolean status=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf","root","root");
		    PreparedStatement ps=cnct.prepareStatement("select * from register where email=? and userpass=?");
		    ps.setString(1, email);
		    ps.setString(2, password);
		   
		    ResultSet rs=ps.executeQuery();
		    status=rs.next();
		}catch(Exception e) {}
		return status;
	}

}
