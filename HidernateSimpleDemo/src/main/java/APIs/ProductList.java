package APIs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import zzzdemo.DAO;

/**
 * Servlet implementation class ProductList
 */
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		request.getSession().setAttribute("produ", dao.productList());
		
		response.sendRedirect("/HidernateSimpleDemo/pages/productlist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		request.getSession().setAttribute("produ", dao.productList());
		
		response.sendRedirect("/HidernateSimpleDemo/pages/productlist.jsp");
	}

}
