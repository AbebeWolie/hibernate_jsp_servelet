package com.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	// SignUp User
	
	public boolean signUp(User users) {
		
		String query = "INSERT INTO users(name,email,password) values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, users.getName());
			pst.setString(2, users.getEmail());
			pst.setString(3, users.getPassword());
			
			int row = pst.executeUpdate();
			return row>0;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// Login User
  
	public User login(String email, String password){
		
		String query = "SELECT * from javatestdb.users where email=? and password=?";
		User user = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			
			PreparedStatement pst = con.prepareStatement(query);
			 pst.setString(1, email);
	         pst.setString(2, password);
	         ResultSet rs = pst.executeQuery();
	            if(rs.next()){
	            	user = new User();
	            	user.setName(rs.getString("name"));
	            	user.setEmail(rs.getString("email"));
	            	user.setPassword(rs.getString("password"));
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            System.out.print(e.getMessage());
	        }
	        return user;

	}
	
	
	
	// Add Product
	
	public boolean addProduc(Product product) {
		
		String query = "INSERT INTO product(id,name,category,price) values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, product.getId());
			pst.setString(2, product.getName());
			pst.setString(3, product.getCategory());
			pst.setInt(4, product.getPrice());
			
			int rowResult = pst.executeUpdate();
			
			return rowResult>0;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
	
	// Fetch Product 
	
	public List<Product> productList(){
		
		List<Product> products = new ArrayList();
		String query = "SELECT *FROM javatestdb.product";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			Product product;
			
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				
				products.add(product);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// Delete Product
	
	
	public boolean deleteProduct(int id) {
		
		
		String query = "DELETE FROM javatestdb.product where id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, id);
			int row = pst.executeUpdate();
			
			return row >0;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
	
// Update Product
	
	
	public Product Update(Product product) {
		//update users set name = ?,email= ?, country =? where id = ?;
		
		String query = "UPDATE javatestdb.product set name=?,category=?,price=? WHERE id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setString(2, product.getCategory());
			pst.setInt(3, product.getPrice());
			pst.setInt(4, product.getId());
			int row = pst.executeUpdate();
			
			if(row>0) {
				return product;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	
// Select By Id
	
	public Product getById(Product pro) {
		
		String query = "SELECT * FROM javatestdb.product WHERE id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatestdb","root","admin");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, pro.getId());
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setCategory(rs.getString(3));
				pro.setPrice(rs.getInt(4));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return pro;
	}
	
	
 // Main Method For Checking 
	
	public static void main(String[] args) {
		List<User> users =new ArrayList();
		
		List<Product> products = new ArrayList();
		User u = new User();
		
		Product pro = new Product();
	

		
		u.setName("AAA");
		u.setEmail("aa@gmail.com");
		u.setPassword("123456");
		
//		product Obj
		
		pro.setId(34);
		pro.setName("mango");
		pro.setCategory("griifdk");
		pro.setPrice(200);
		

		
		
		
	DAO deo = new DAO();
	
	Product pr = deo.getById(pro);
	System.out.println(pr.getId() + pr.getName());
//	boolean result = deo.deleteProduct(pro.getId());
//	System.out.println(result);
	//Product check = deo.Update(pro);
	
	//System.out.println(check.getId());
	
	//products = deo.productList();
	
	//System.out.println(check);
	
//users = deo.login("berket@gmail.com","babg");
	
//	for(Product use:products) {
//		System.out.println("Id is : " + use.getId());
//		System.out.println("Name is : " + use.getName());
//		System.out.println("Category is : " + use.getCategory());
//		System.out.println("price is : " + use.getPrice());
//	}
//	boolean result = deo.signUp(u);
//	System.out.println(deo);
	}
}
