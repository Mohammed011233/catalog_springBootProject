package com.catalog.services;

import com.catalog.entities.Category;
import com.catalog.models.CategoryModel;

import java.util.List;

public interface CategoryServiceInterface {

    Category insertcategory(CategoryModel categoryModel);

    Category updateCategory(CategoryModel categoryModel);

    CategoryModel findCategoryById(Long id);

    List<CategoryModel> findAllCategory();

    void deleteCategory(Long id);
}
