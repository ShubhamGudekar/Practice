package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository // Mandatory ano to tell SC following is a spring bean
//containing DAL(data access logic)
@Transactional //enable transaction //skipped service layer as no specific bl
public class ProductDaoImpl implements ProductDao {
	// dependency : SF
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Product> getProductsByDesc(String key1) {

		String jpql = "select p from Product p where p.description like :key";
		return mgr.createQuery(jpql, Product.class).setParameter("key", "%" + key1 + "%").getResultList();

	}

}
