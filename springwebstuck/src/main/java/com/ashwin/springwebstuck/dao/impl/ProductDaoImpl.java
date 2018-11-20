package com.ashwin.springwebstuck.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashwin.springwebstuck.dao.ProductDAO;
import com.ashwin.springwebstuck.entity.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getById(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return sessionFactory
				.getCurrentSession().
				createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.
			getCurrentSession().persist(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.
			getCurrentSession().update(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setActive(false);
			sessionFactory.
			getCurrentSession().update(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProduct() {
		String selectActiveProducts="FROM Product where active= :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active", true).getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM Product where active= :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active= :active ORDER By id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
