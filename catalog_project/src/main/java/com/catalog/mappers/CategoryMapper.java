package com.catalog.mappers;

import com.catalog.entities.Category;
import com.catalog.models.CategoryModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CategoryMapper {

    CategoryModel toCategoryModel(Category category);

    Category toCategoryEntity(CategoryModel categoryModel);
}
