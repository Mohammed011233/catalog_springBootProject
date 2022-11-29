package com.catalog.services;

import com.catalog.entities.Product;
import com.catalog.models.ProductModel;

import java.util.List;

//(This service interface to implement the important SOLUD prensible
// that is Don't dependant on conceret class but dependant on abstract class->interface)
public interface ProductServiceInterface {

   Product insertProduct(ProductModel productModel);

   Product updateProduct(ProductModel productModel);

   ProductModel findProductById(Long id);

   List<ProductModel> findAllProduct();

   List<ProductModel> findProductByCategory(Long id);

   List<ProductModel> getAllProductSortedByPopurity();

   void deleteProduct(Long id);
    
}
