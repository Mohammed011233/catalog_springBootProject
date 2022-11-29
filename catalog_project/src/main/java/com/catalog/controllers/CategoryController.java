package com.catalog.controllers;

import com.catalog.entities.Category;
import com.catalog.mappers.CategoryMapper;
import com.catalog.models.CategoryModel;
import com.catalog.services.implementation.CategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @PostMapping("insert")
    public Category insertCategory(@Valid @RequestBody CategoryModel categoryModel){

        return categoryService
                .insertcategory(categoryModel);
    }

    @PutMapping("update")
    public Category updateCategory(@Valid @RequestBody CategoryModel categoryModel){

        return categoryService
                .updateCategory(categoryModel);
    }

    @GetMapping("{id}")
    public CategoryModel getCatagory(@PathVariable Long id){
       return categoryService
                    .findCategoryById(id);

    }

    @GetMapping("")
    public List<CategoryModel> getAllCatagory(){
//        this stream to map all category in category list to model
        return categoryService
                .findAllCategory();

    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService
                .deleteCategory(id);
    }


}
