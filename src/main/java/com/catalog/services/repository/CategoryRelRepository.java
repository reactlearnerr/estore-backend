package com.catalog.services.repository;

import com.catalog.services.entity.Category;
import com.catalog.services.entity.CategoryRel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRelRepository extends JpaRepository<CategoryRel, Integer> {

    @Query(value="select c from CategoryRel c where c.categoryIdParent = :topCategoryId")
    List<CategoryRel> findChildCategoriesForCategory(@Param("topCategoryId") Integer topCategoryId);

    // @Query(value="insert into catgrprel (category_id_child,category_id_parent) values ()",nativeQuery = true)
    // CategoryRel assignSubCategoriesForTopCategory(Integer categoryId);


}