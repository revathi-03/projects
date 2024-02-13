package rev;
import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userlogin")
@SuppressWarnings("serial")
public class Loginservlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDAO dao=new UserDAO();
		UserDTO dto=dao.userinfo(email);
		
		
		if(dao.validate(email,password))
	{
		HttpSession session=request.getSession();	
		session.setAttribute("user", dto);
		RequestDispatcher rd=request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
	
		
		}
	else {
		out.print("sorry email or password error");
		RequestDispatcher rd=request.getRequestDispatcher("/login1.html");
		rd.forward(request, response);
		
		
	}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
