package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Category;
import pojos.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProductToCategory(Long categoryId, Product newProduct) {
		String mesg="adding product failed!!!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//get category details from it's id
			Category category=session.get(Category.class, categoryId);
			if(category != null)
			{
				//establish bi dir asso
				category.addProduct(newProduct);
				//save product details
				session.persist(newProduct);
				mesg="product added ID "+newProduct.getId();
			}				
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteProduct(Long categoryId, Long productId) {
		String mesg="deleting product failed!!!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//get category details from it's id
			Category category=session.get(Category.class, categoryId);
			Product product = session.get(Product.class, productId);
			if(category != null && product!=null)
			{
				
				//category.deleteProduct(newProduct);
				
				session.delete(product);;
				mesg="product deleted successfully";
			}				
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	
}
