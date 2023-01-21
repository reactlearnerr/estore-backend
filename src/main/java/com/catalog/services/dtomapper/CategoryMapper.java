package com.catalog.services.dtomapper;

import com.catalog.services.dto.CategoryDto;
import com.catalog.services.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .identifier(categoryDto.getIdentifier())
                .imageUrl(categoryDto.getImageUrl())
                .build();
    }

    public CategoryDto categoryToCategoryDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .identifier(category.getIdentifier())
                .imageUrl(category.getImageUrl())
                .build();
    }

}
