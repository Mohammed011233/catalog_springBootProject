package com.catalog.models;

import com.catalog.entities.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class ProductModel {

    private Long productId;

    @NotBlank(message = "please enter valid name")
    @Pattern(regexp = "^[\\u0621-\\u064A \\u0660-\\u0669]+$"
            , message = "ارجو ادخال المنتج باللغة العربية")
    private String productNameAr;

    @NotBlank(message = "please enter valid name")
    @Pattern(regexp = "^[a-zA-Z0-9 ?><;,{}_+=!@#$%\\^&*|']*$"
            , message = "please enter only english name for the product")
    private String productNameEn;

    @NotNull(message = "please enter price for product")
    @Min(value = 1 , message = "please enter price greater than 1 pount")
    private Double price;

    @NotNull(message = "please enter quantity for product")
    @Min(value = 1 , message = "the quantity of product must be greater than 1 ")
    private Integer quantityProducts;

    @Min(value = 1 , message = "please enter at least 1 as quantity of product")
    @Max(value = 5 , message = "please enter at more 5 as quantity of product")
    private Integer quantityOrdered;


    private Integer popurity;

//    private VectorOperators.Binary image;

    @NotNull(message = "please enter category of product")
    private CategoryModel categoryModel;

}
