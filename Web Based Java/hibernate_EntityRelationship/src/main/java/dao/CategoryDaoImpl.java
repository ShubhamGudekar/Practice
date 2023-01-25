package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category newCategory) {
		String mesg = "Adding category failed";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newCategory);
			tx.commit();
			mesg = "New category added with ID " + newCategory.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteCategory(String categoryName) {
		String msg = "Category Deletion failed";
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String jpql = "select c from Category c where c.categoryName = :category ";
		try {

			Category cat = session.createQuery(jpql, Category.class).setParameter("category", categoryName)
					.getSingleResult();
			session.delete(cat);
			transaction.commit();
			msg=categoryName+ " category deleted successfully";
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}

}
