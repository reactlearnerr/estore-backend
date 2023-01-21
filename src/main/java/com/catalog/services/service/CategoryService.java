package com.catalog.services.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.services.dto.CategoryDto;
import com.catalog.services.dtomapper.CategoryMapper;
import com.catalog.services.entity.Category;
import com.catalog.services.repository.CategoryRepository;

@Service
public class CategoryService {
	Logger log = Logger.getLogger(CategoryService.class.getName());
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryDto getCategoryDetails(String categoryId){
        Optional<Category> category = categoryRepository.findById(Integer.valueOf(categoryId));
        return categoryMapper.categoryToCategoryDto(category.get());
    }

    public List<Category> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public List<Category> getAllTopCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().filter(category -> category.isTopCategory()).collect(Collectors.toList());
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category categoryToSave = categoryMapper.categoryDtoToCategory(categoryDto);
        log.info("categoryDto: "+categoryDto);
        log.info("categoryToSave: "+categoryToSave);
        Category category = categoryRepository.saveAndFlush(categoryToSave);
        CategoryDto categorySaved = categoryMapper.categoryToCategoryDto(category);
        return categorySaved;

    }

    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(Integer.valueOf(categoryId));
    }

    public Category updateCategoryDetails(String categoryId,Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(Integer.valueOf(categoryId));
        return categoryRepository.saveAndFlush(existingCategory.get());
    }
}
