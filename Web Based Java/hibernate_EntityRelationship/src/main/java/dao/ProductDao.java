package dao;

import pojos.Product;

public interface ProductDao {
//Add Product to the category
	String addProductToCategory(Long categoryId,Product newProduct);
	
	//delete a product from category
	String deleteProduct(Long categoryId,Long productId);
}
