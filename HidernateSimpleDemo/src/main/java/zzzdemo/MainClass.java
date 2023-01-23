package zzzdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Product;
import model.User;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("Hello World Guys");
		Product pro = new Product();
		pro.setId(3);;
		pro.setName("Mangoooo");
		pro.setCategory("fruooooooooit");
		pro.setPrice(120000000);
		
		int x=3;
   
		DAO dao = new DAO();
		
		
		
     	//dao.addProduct(pro);
//		dao.DeleteProduct(x);
		//dao.productList();
		List<Product> products =dao.updateProduct(x);
		
		for(Product prod : products) {
			System.out.println(prod.getName());
		}
		
		boolean check = dao.update(pro);
		System.out.println(check);
		
		User user = new User();
		user.setName("Alemu");
		user.setEmail("algmailemu@.com");
		user.setPassword("123456");
		User user1 = new User();
		user1.setEmail("abebe@gmail.com");
		user1.setName("Kebede");
		user1.setPassword("123456");
		
//		boolean x= dao.signUp(user);
//		System.out.println(x);
//		System.out.println(pro.getName());
//		System.out.println(dao.login("abebe@gmail.com","12345678").getName());
		
	}

}
