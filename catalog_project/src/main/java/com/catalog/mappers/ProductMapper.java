package com.catalog.mappers;

import com.catalog.entities.Product;
import com.catalog.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {

//    the mapStruct is mapping between the source Entite (Product) and the target model (ProductModel)
//    if the name of properetes in the model is not same Props name in Entite
//    you need add @Mapping(source = "Entite_prop_name" , target="model_prop_name")

    @Mapping(source = "id" , target = "productId")
    @Mapping(source = "quantity" , target = "quantityProducts")
    @Mapping(source = "popurity" , target = "popurity")
    @Mapping(source = "lastQuantityOrdered" , target = "quantityOrdered")
    @Mapping(source = "category" , target = "categoryModel")
    ProductModel toProductModel(Product product);

    @Mapping(source = "productId"  ,target = "id")
    @Mapping(source = "quantityProducts" , target = "quantity")
    @Mapping(source = "popurity" , target = "popurity")
    @Mapping(source = "quantityOrdered" , target = "lastQuantityOrdered")
    @Mapping(source = "categoryModel" , target = "category")
    Product toProductEntity(ProductModel productModel);

}

//##################################
//this two method (toEntity , toModel) to mapping the values (to and from) the model and Entity
//the mapStruct is libirary help to generate which make this mapping
//    private Product toEntity(ProductModel productModel){
//        Product product = new Product();
//
//        product.setId(productModel.getId());
//        product.setProductNameAr(productModel.getProductNameAr());
//        product.setProductNameEn(productModel.getProductNameEn());
//        product.setPrice(productModel.getPrice());
//        product.setQuantity(productModel.getQuantity());
//        product.setCategory(productModel.getCategory());
////        product.setImage(productModel.getImage());
//
//        return product;
//    }
//
//    private ProductModel toModel(Product product){
//        ProductModel productModel = new ProductModel();
//
//        productModel.setId((product.getId()));
//        productModel.setProductNameAr(product.getProductNameAr());
//        productModel.setProductNameEn(product.getProductNameEn());
//        productModel.setPrice(product.getPrice());
//        productModel.setQuantity(product.getQuantity());
//        productModel.setCategory(product.getCategory());
////        productModel.setImage(product.getImage());
//
//        return productModel;
//    }
//#############################################