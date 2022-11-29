package com.catalog.services.implementation;

import com.catalog.entities.Category;
import com.catalog.entities.Product;
import com.catalog.mappers.ProductMapper;
import com.catalog.models.ProductModel;
import com.catalog.repositries.CategoryRepo;
import com.catalog.repositries.ProductRepo;
import com.catalog.services.ProductServiceInterface;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    public Product checkValidId(Long id) {
        return productRepo
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not fond this product"));

    }

    //    this method to check if category is exist or not
    public void checkExistCategory(Long id) {
        categoryRepo
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("which category that you input is not exist"));
    }


    //############################# TODO you can use mapStruct code generator
// TODO to generate Thay two method which in the ProductMapper interface as comment (I make thay by my hand :) ) automaticaly
// TODO by only make interface contain abstrct methods that contain the Entite and the model
    @Override
    public Product insertProduct(ProductModel productModel) {
//      check the category that input is exist or not
        checkExistCategory(productModel
                .getCategoryModel().getId());


        productModel.setProductId(null);
        productModel.setPopurity(1);
        productModel.setQuantityOrdered(0);

        Product modelToProduct =
                productMapper
                        .toProductEntity(productModel);

        return productRepo
                .save(modelToProduct);
    }

    @Override
    public Product updateProduct(ProductModel productModel) {
        Product product = productMapper.toProductEntity(productModel);

        Product productFromDB = checkValidId(product.getId());

        checkExistCategory(productModel
                .getCategoryModel().getId());

        product.setLastQuantityOrdered(productFromDB.getLastQuantityOrdered());
        product.setPopurity(productFromDB.getPopurity());

        return productRepo
                .save(product);
    }

    @Override
    public ProductModel findProductById(Long id) {

        Product productEntity =
                productRepo
                        .findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Not found this product"));

        return productMapper
                .toProductModel(productEntity);
    }

    @Override
    public List<ProductModel> findAllProduct() {
        return productRepo
                .findAll()
                .stream()
                .map(product -> productMapper.toProductModel(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> findProductByCategory(Long id) {
        checkExistCategory(id);

        return productRepo
                .findBycategoryId(id)
                .stream()
                .map(product -> productMapper.toProductModel(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> getAllProductSortedByPopurity() {
        return productRepo
                .findByOrderByPopurityDesc()
                .stream()
                .map(product -> productMapper.toProductModel(product))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
