package com.ashwin.springwebstuck.dao;

import com.ashwin.springwebstuck.entity.Address;
import com.ashwin.springwebstuck.entity.Cart;
import com.ashwin.springwebstuck.entity.User;

public interface UserDAO {

	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);
	
}
