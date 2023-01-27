package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import pojos.Category;

public class DeleteProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Hibernate up n running !" + sf);
			ProductDaoImpl dao = new ProductDaoImpl();
			System.out.println("Enter categoryId productId");
			System.out.println(dao.deleteProduct(sc.nextLong(), sc.nextLong()));

		} // JVM : sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
