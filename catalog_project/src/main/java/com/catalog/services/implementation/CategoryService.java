package com.catalog.services.implementation;

import com.catalog.entities.Category;
import com.catalog.mappers.CategoryMapper;
import com.catalog.models.CategoryModel;
import com.catalog.repositries.CategoryRepo;
import com.catalog.services.CategoryServiceInterface;
import com.catalog.services.CheckId;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryServiceInterface , CheckId<Category> {
    @Autowired
    private CategoryRepo categoryRepo ;

    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Override
    public Category insertcategory(CategoryModel categoryModel) {

        try{
            return categoryRepo
                    .findByCategoryName(categoryModel.getCategoryName())
                    .orElseThrow(() -> new RuntimeException("This category is aready exist"));
        }catch(RuntimeException ex){
            Category toCategoryEntity = categoryMapper
                    .toCategoryEntity(categoryModel);

            return categoryRepo
                    .save(toCategoryEntity);
        }



    }

    @Override
    public Category updateCategory(CategoryModel categoryModel) {

        categoryRepo
                .findById(categoryModel.getId())
                .orElseThrow(() -> new NoSuchElementException("this category is not found"));

        Category toCategoryEntity = categoryMapper
                .toCategoryEntity(categoryModel);

        return categoryRepo
                .save(toCategoryEntity);
    }

    @Override
    public CategoryModel findCategoryById(Long id) {
        Category category =
                categoryRepo
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("this category is not exist !!!"));

        return categoryMapper
                .toCategoryModel(category);

    }

    @Override
    public List<CategoryModel> findAllCategory() {

        return categoryRepo
                .findAll()
                .stream()
                .map(category -> categoryMapper.toCategoryModel(category))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo
                .deleteById(id);
    }
}
