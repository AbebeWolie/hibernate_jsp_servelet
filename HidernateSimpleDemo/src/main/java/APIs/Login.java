package APIs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import zzzdemo.DAO;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user= dao.login(email, password);
		
		if (user !=null) {
			
			request.getSession().setAttribute("auth", user);
		    response.sendRedirect("/HidernateSimpleDemo/index.jsp");
		}else {
			response.sendRedirect("/HidernateSimpleDemo/pages/error.jsp");
		}
	
		
	}

}
