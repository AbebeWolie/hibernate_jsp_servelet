package APIs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import zzzdemo.DAO;


public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Product> products = dao.updateProduct(id);
		request.getSession().setAttribute("ids", id);
		
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("product", products);
		response.sendRedirect("/HidernateSimpleDemo/pages/update.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		Product product = new Product();
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		
		product.setId(id);
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);
		dao.update(product);
		
		response.sendRedirect("/HidernateSimpleDemo/ProductList");
		
		
	}

}
