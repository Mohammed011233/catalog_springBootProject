package com.catalog.controllers;

import com.catalog.entities.Product;
import com.catalog.mappers.ProductMapper;
import com.catalog.models.ProductModel;
import com.catalog.services.implementation.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("catalog/product")
public class ProductControler {

    @Autowired
    private ProductService productService;
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @PostMapping("insert")
    public Product insertProduct(@RequestBody @Valid ProductModel productModel) {

        return productService
                .insertProduct(productModel);
    }

    @PutMapping("update")
    public Product updateProduct(@RequestBody @Valid ProductModel productModel) {
        return productService
                .updateProduct(productModel);
    }


    @GetMapping("{id}")
    public ProductModel getProductById(@PathVariable Long id) {
        return productService
                .findProductById(id);

    }

    @GetMapping
    public Set<ProductModel> getAllProducts() {
        return productService
                .findAllProduct()
                .stream()
                .collect(Collectors.toSet());

    }

    @GetMapping("category/{categoryId}")
    public Set<ProductModel> getAllProductInCategory(@PathVariable Long categoryId) {
        return productService
                .findProductByCategory(categoryId)
                .stream()
                .collect(Collectors.toSet());
    }

    @GetMapping("sort/popurity")
    public List<ProductModel> sortByPopurity(){
        return productService
                .getAllProductSortedByPopurity();

    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService
                .deleteProduct(id);
    }


}
