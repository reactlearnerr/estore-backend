package com.catalog.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.services.dto.CategoryRelDto;
import com.catalog.services.entity.Category;
import com.catalog.services.entity.CategoryRel;
import com.catalog.services.repository.CategoryRelRepository;
import com.catalog.services.repository.CategoryRepository;

@Service
public class CategoryRelService {
    @Autowired
    CategoryRelRepository categoryRelRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryRel assignSubCategoryForTopCategory(CategoryRelDto catGrpRelRequest){
        Optional<Category> categoryIdChild = categoryRepository.findByIdentifier(catGrpRelRequest.getChildCategory());
        Optional<Category> categoryIdParent = categoryRepository.findByIdentifier(catGrpRelRequest.getParentCategory());
        CategoryRel categoryRel = CategoryRel.builder()
        .categoryIdChild(Integer.valueOf(categoryIdChild.get().getCategoryId()))
        .categoryIdParent(Integer.valueOf(categoryIdParent.get().getCategoryId()))
        .relationType(catGrpRelRequest.getRelationType())
        .build();
      return categoryRelRepository.saveAndFlush(categoryRel);
    }

    public List<CategoryRel> getSubCategoriesForTopCategory(String topCategory){
        Optional<Category> topCategoryId = categoryRepository.findByIdentifier(topCategory);
        List<CategoryRel> categories = categoryRelRepository.findChildCategoriesForCategory(topCategoryId.get().getCategoryId());
        return categories;
    }

}
