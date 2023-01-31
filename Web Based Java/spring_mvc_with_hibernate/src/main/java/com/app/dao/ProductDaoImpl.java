package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository // Mandatory ano to tell SC following is a spring bean
//containing DAL(data access logic)
@Transactional
public class ProductDaoImpl implements ProductDao {
	// dependency : SF
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Product> getProductsByDesc(String key1) {

		String jpql = "select p from Product p where p.description like :key";
		System.out.println(factory.getCurrentSession() + " key 1 :" + key1);
		List<Product> p = factory.getCurrentSession().createQuery(jpql, Product.class)
				.setParameter("key", "%" + key1 + "%").getResultList();

		p.forEach(System.out::println);

		return p;

	}

}
