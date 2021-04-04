package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.Category;
import com.vts.product.service.service.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    @Mapping(source = "parentCategory.id", target = "parentCategoryId")
    CategoryDTO toDto(Category category);

    @Mapping(source = "parentCategoryId", target = "parentCategory")
    Category toEntity(CategoryDTO categoryDTO);

    default Category fromId(Long id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }
}
