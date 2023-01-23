package zzzdemo;
import model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DAO {

	public boolean signUp(User user) {
		
	Configuration config = new Configuration();
	config.configure("hibernate.cfg.xml");
	
	Session session = config.buildSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	session.save(user);
	 
	trans.commit();
	session.close();
	
		return true;
	}
	
	public User login(String em, String password) {
		
		User user = null;
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<User> users = session.createQuery("from User").list();
		for(User usr:users) {
			if(em.equals(usr.getEmail())) {
				user = new User();
				user.setEmail(em);
				user.setName(usr.getName());
				user.setPassword(user.getPassword());
			}
			
		}

		trans.commit();
		session.close();
		return user;
		
	}
	
	public boolean addProduct(Product product) {
		
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		
		Transaction trans = session.beginTransaction();
		session.persist(product);
		trans.commit();
		session.close();
		
		return true;
		
	}
	
	
	public List<Product> productList(){
		
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
			
		List<Product> products = session.createQuery("from Product").list();
		
		for(Product product:products) {
			
			System.out.println(product.getName());
		}
		
		trans.commit();
		session.close();
		
		return products;
	}
	
	
	public void DeleteProduct(int prod) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		Session session = config.buildSessionFactory().openSession();
		
		Transaction trans = session.beginTransaction();
		
		Query product = session.createQuery("DELETE FROM Product WHERE id = :pro");
		product.setParameter("pro", prod);
		product.executeUpdate();
		trans.commit();
		session.close();
		
	}
	
	
	
	
	public List<Product> updateProduct(int id ) {
		
		Product prod;
		Configuration config= new Configuration();
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Product>  products = session.createQuery("FROM Product WHERE id=id").list();
		
		trans.commit();
		session.close();
		
		return products;
	}
	
	
 public boolean update( Product  pro) {
	 
	 Configuration config = new Configuration();
	 config.configure("hibernate.cfg.xml");
	 Session session = config.buildSessionFactory().openSession();
	 Transaction trans = session.beginTransaction();
	 Product produ = session.get(Product.class, pro.getId());
	 	produ.setName(pro.getName());
	 	produ.setCategory(pro.getCategory());
	 	produ.setPrice(pro.getPrice());
	 	
		session.update(produ);
		trans.commit();
		session.close();
	 
	 return true;
 }
	
}
