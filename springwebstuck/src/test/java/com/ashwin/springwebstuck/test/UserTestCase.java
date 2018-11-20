package com.ashwin.springwebstuck.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashwin.springwebstuck.dao.CategoryDAO;
import com.ashwin.springwebstuck.dao.ProductDAO;
import com.ashwin.springwebstuck.dao.UserDAO;
import com.ashwin.springwebstuck.entity.Address;
import com.ashwin.springwebstuck.entity.Cart;
import com.ashwin.springwebstuck.entity.Category;
import com.ashwin.springwebstuck.entity.User;

public class UserTestCase {
	
public static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user =null;
	private Cart cart =null;
	private Address address =null;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ashwin.springwebstuck.*");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
		}
	
		@Test
		public void testAdd() {
			user = new User() ;
			user.setFirstName("Hrithik");
			user.setLastName("Roshan");
			user.setEmail("hr@gmail.com");
			user.setContactNumber("1234512345");
			user.setRole("USER");
			user.setEnabled(true);
			user.setPassword("12345");
			
			//add the user
			assertEquals("Failed to add the user!",true,userDAO.addUser(user));
			
			address = new Address();
			address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
			address.setAddressLineTwo("Near Kaabil Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setBilling(true);
			
			//link the user with address
			address.setUserId(user.getId());
			
			//add the address
			assertEquals("Failed to add the address!",true,userDAO.addAddress(address));
			
			if(user.getRole().equals("USER")) {
				//create a cart for this user
				
				cart=new Cart();
				cart.setUser(user);
				
				//add the cart
				assertEquals("Failed to add the cart!",true,userDAO.addCart(cart));
				
				//add a shipping address for user;
				address = new Address();
				address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
				address.setAddressLineTwo("Near Kudrat Store");
				address.setCity("Mumbai");
				address.setState("Maharashtra");
				address.setCountry("India");
				address.setPostalCode("400001");
				address.setBilling(true);
				
				//link it with user
				address.setUserId(user.getId());
				
				//add the shipping address
				assertEquals("Failed to add the shipping address!",true,userDAO.addAddress(address));
			}
		}
}
