package com.catalog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CategoryModel {

    private Long id;

    @NotBlank(message = "Please enter the category name")
    private String categoryName;

}
