package com.catalog.services.controller;

import com.catalog.services.dto.CategoryDto;
import com.catalog.services.dto.CategoryRelDto;
import com.catalog.services.entity.Category;
import com.catalog.services.entity.CategoryRel;
import com.catalog.services.service.CategoryRelService;
import com.catalog.services.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/api/v1")
@CrossOrigin( origins = {"http://localhost:3000","http://localhost:8001","http://localhost:5173"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRelService categoryRelService;

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryDetails(@PathVariable("categoryId") String categoryId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.getCategoryDetails(categoryId));
    }


    @PostMapping(path = "/create")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto requestCategory){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(requestCategory));
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") String categoryId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("category deleted..");
    }

    @PatchMapping(path = "/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.updateCategoryDetails(categoryId,category));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.getAllCategories());
    }

    @GetMapping(path = "/sub-categories/{topCategory}")
    public ResponseEntity<List<CategoryRel>> getSubCategoriesForTopCategory(@PathVariable String topCategory){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryRelService.getSubCategoriesForTopCategory(topCategory));
    }

    @GetMapping(path = "/@top")
    public ResponseEntity<List<Category>> getAllTopCategories(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.getAllTopCategories());
    }

    @PostMapping(path = "/assign-subcategories")
    public ResponseEntity<CategoryRel> assignSubCategoryForTopCategory(@RequestBody CategoryRelDto catGrpRelRequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryRelService.assignSubCategoryForTopCategory(catGrpRelRequest));
    }
}
