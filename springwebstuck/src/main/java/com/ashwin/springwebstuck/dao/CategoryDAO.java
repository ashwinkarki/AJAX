package com.ashwin.springwebstuck.dao;

import java.util.List;

import com.ashwin.springwebstuck.entity.Category;

public interface CategoryDAO {
    
	List<Category> getAllCategory();
	Category getById(int id);
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
	
}
