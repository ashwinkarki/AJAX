package com.ashwin.springwebstuck.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashwin.springwebstuck.dao.CategoryDAO;
import com.ashwin.springwebstuck.entity.Category;


public class CategoryTestCase2 {
public static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ashwin.springwebstuck.*");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		
	}
	
	/*@Test  it is test for inserting
	public void testAddCategory() {
		category=new Category();
		category.setName("Television");
		category.setDescription("teelvision");
		category.setImageUrl("television");
		
		assertEquals("sucesfully adeed in table",true,categoryDAO.addCategory(category));
		
	}*/
	
	//test for getting single category
	/*@Test
	public void getCategory() {
		category=categoryDAO.getById(1);
		assertEquals("sucesfully get from in table","Television",category.getName());
		
		
	}*/
	
	

	/*//test for updating category
	@Test
	public void updateCategory() {
		category=categoryDAO.getById(1);
		category.setName("Mobile");
		assertEquals("sucesfully updated in table",true,categoryDAO.updateCategory(category));
		
		
	}*/
	
	
	/*//test for deleteing category
	@Test
	public void deleteCategory() {
		category=categoryDAO.getById(1);
		category.setName("Mobile");
		assertEquals("sucesfully deleted in table",true,categoryDAO.deleteCategory(category));
		
		
	}*/
	
	/*//test for get all category
	@Test
	public void testListCategory() {
		category=categoryDAO.getById(1);
		category.setName("Mobile");
		assertEquals("sucesfully fexted all categories",1,categoryDAO.getAllCategory().size());
		
		
	}*/
	
	/*@Test
	public void testCRUDCategory() {
		category=new Category();
		category.setName("Radios");
		category.setDescription("this is radio");
		category.setImageUrl("television");
		
		assertEquals("sucesfully adeed in table",true,categoryDAO.addCategory(category));
		
		category=new Category();
		category.setName("Television");
		category.setDescription("this is television");
		category.setImageUrl("television");
		
		assertEquals("sucesfully adeed in table",true,categoryDAO.addCategory(category));
	
		//fetaching and renaming category
		category=categoryDAO.getById(1);
		category.setName("Mobile");
		assertEquals("sucesfully updated in table",true,categoryDAO.updateCategory(category));
	
		//deleting the cateogry
		assertEquals("sucesfully deleted in table",true,categoryDAO.deleteCategory(category));
	
		
		//taking all list
		assertEquals("sucesfully fexted all categories",1,categoryDAO.getAllCategory().size());
	
	}
	*/
		
	
	

}
